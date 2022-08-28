package diaspora
import wslite.rest.*

class UtilFollowers {
    final String url
    String token=null
    final RESTClient client

    UtilFollowers(String url){
        this.url = url
        this.client = new RESTClient(url)
    }

    List getFollowers(String username, String token){
        this.client.get(
            path:"users/$username/followers",
            headers:["Authorization":"token $token"]).json*.login
        }
    List getFollowers(String username){
        this.token ?
        this.client.get(
            path:"users/$username/followers",
            headers:["Authorization":"token $this.token"]).json*.login :
        this.client.get(path:"users/$username/followers").json*.login
        }

    List getCommonFollowers(List users){
        List shareFollowers = []
        shareFollowers = users.collect{ user -> getFollowers( user ) }
        shareFollowers.inject(shareFollowers[0]){
            intersection, followers -> followers.intersect(intersection)  }
        }
    List getFollowRelation( List users ){
        users.collect{user ->
            //they follow person <=> person is been follow by them
            [user : getFollowers(user).intersect(users) ]
        }
    }
}
