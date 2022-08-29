package diaspora
import wslite.rest.*


List usernames = ["3rickDJ", "ghector6"]
String API_KEY = new File('/home/erick/Code/repos/diaspora', 'ENV').collect{it}.join("")
def GitHubfollowers = new UtilFollowers('https://api.github.com')
GitHubfollowers.token = API_KEY
List commonfollowers = GitHubfollowers.getCommonFollowers(usernames)

List relationshipCommonFollowers = GitHubfollowers.getFollowRelation(commonfollowers)
def graficar = new Graph()
String FollowersOfFollowers = graficar.graphvizFollowersOfFollowers(relationshipCommonFollowers)
String CommonFollowers = graficar.graphvizFollowers(usernames, commonfollowers)

println FollowersOfFollowers
println CommonFollowers
