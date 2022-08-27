package diaspora

import wslite.rest.*

def usernames = ["3rickDJ", "ghector6"]
def API_KEY = new File('/home/erick/Code/repos/diaspora', 'ENV').collect{it}.join("")
def client = new RESTClient("https://api.github.com")
def responses = usernames.collect{
    client.get(path:"users/$it/followers", headers:["Authorization" :"token $API_KEY"])
    }
println responses*.json*.login
assert [200,200] == responses*.statusCode
println responses[0].json*.login.intersect(responses[1].json*.login)
