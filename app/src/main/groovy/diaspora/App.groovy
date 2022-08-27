package diaspora

import wslite.rest.*

def usernames = ["3rickDJ", "ghector6"]

def client = new RESTClient("https://api.github.com")
def responses = usernames.collect{client.get(path:"users/$it/followers")}
println responses*.json*.login
assert [200,200] == responses*.statusCode
