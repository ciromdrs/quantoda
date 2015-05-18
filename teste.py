# -*- coding:utf-8 -*-
import cgi
import urllib

from google.appengine.api import users
from google.appengine.ext import ndb

import webapp2

# Página HTML (colocaremos isto dentro de um arquivo mais tarde)
MAIN_PAGE_FOOTER_TEMPLATE = """\
    <form action="/sign?%s" method="post">
      <div><textarea name="content" rows="3" cols="60"></textarea></div>
      <div><input type="submit" value="Assinar"></div>
    </form>
    <hr>
    <form>Nome do livro:
      <input value="%s" name="guestbook_name">
      <input type="submit" value="switch">
    </form>
    <a href="%s">%s</a>
  </body>
</html>
"""

# Livro de saudações padrão
DEFAULT_GUESTBOOK_NAME = 'default_guestbook'

# Chave usada para garantir a consistência
def guestbook_key(guestbook_name=DEFAULT_GUESTBOOK_NAME):
    '''Cria uma Datastore key para um Guestbook.
    Usamos o parâmetro guestbook_name como chave.'''
    return ndb.Key('Guestbook', guestbook_name)

# Entidades
class Author(ndb.Model):
    '''Sub model que representa um autor.'''
    identity = ndb.StringProperty(indexed=False)
    email = ndb.StringProperty(indexed=False)


class Greeting(ndb.Model):
    '''Modelo que representa uma assinatura (saudação)'''
    author = ndb.StructuredProperty(Author)
    content = ndb.StringProperty(indexed=False)
    date = ndb.DateTimeProperty(auto_now_add=True)

# Handlers
class MainPage(webapp2.RequestHandler):
    def get(self):
        self.response.write('<html><body>')
        guestbook_name = self.request.get('guestbook_name',
                                          DEFAULT_GUESTBOOK_NAME)

        # Recuperando as saudações
        greetings_query = Greeting.query(
            ancestor=guestbook_key(guestbook_name)).order(-Greeting.date)
        greetings = greetings_query.fetch(10)

        user = users.get_current_user()
        for greeting in greetings:
            if greeting.author:
                author = greeting.author.email
                self.response.write('<b>%s</b> wrote:' % author)
            else:
                self.response.write('Alguém escreveu:')
            self.response.write('<blockquote>%s</blockquote>' %
                                cgi.escape(greeting.content))

        if user:
            url = users.create_logout_url(self.request.uri)
            url_linktext = 'Logout'
        else:
            url = users.create_login_url(self.request.uri)
            url_linktext = 'Login'

        # Escrevendo o formulário
        sign_query_params = urllib.urlencode({'guestbook_name':
                                              guestbook_name})
        self.response.write(MAIN_PAGE_FOOTER_TEMPLATE %
                            (sign_query_params, cgi.escape(guestbook_name),
                             url, url_linktext))

class Guestbook(webapp2.RequestHandler):
    def post(self):
        # Garantindo a consistência
        guestbook_name = self.request.get('guestbook_name',
                                          DEFAULT_GUESTBOOK_NAME)
        greeting = Greeting(parent=guestbook_key(guestbook_name))

        if users.get_current_user():
            greeting.author = Author(
                    identity=users.get_current_user().user_id(),
                    email=users.get_current_user().email())

        greeting.content = self.request.get('content')
        greeting.put()

        query_params = {'guestbook_name': guestbook_name}
        self.redirect('/?' + urllib.urlencode(query_params))

# Instanciando a aplicação
app = webapp2.WSGIApplication([
    ('/', MainPage),
    ('/sign', Guestbook),
], debug=True)
