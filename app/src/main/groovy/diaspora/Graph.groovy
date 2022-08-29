package diaspora
class Graph {
    String graphvizFollowersOfFollowers(List relations){
        relations.collect{relation ->
            relation.collect{user,followers->
                followers.collect{follower -> "\"$follower\" -> \"$user\";"}.join("\n")
            }.join("\n")
        }.join("\n")
    }
    String graphvizFollowers(List users, List commonFollowers){
        users.collect{user->
            commonFollowers.collect{follower->
                "\"$follower\" -> \"$user\";"
            }.join("\n")
        }.join("\n")
    }
}
