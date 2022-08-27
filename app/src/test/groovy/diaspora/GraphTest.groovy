package diaspora

class GraphTest extends GroovyTestCase {
    void testGraphvizFollowersOfFollowers(){
        Graph graph = new Graph()
        def followerRelationship = [["doguedogue":["maria","mario","matrushka","madrushka"]],["papaJohn":["potata","panckes"]],["piruleta":[]]]
        def result = graph.graphvizFollowersOfFollowers(followerRelationship)
        assert result != null
    }
    void testGraphvizFollowers(){
        Graph graph = new Graph()
        def users = ["3rickDJ","gHector6"]
        def commonFollowers = ["doguedogue","maria","mario","matrushka","madrushka","papaJohn","potata","panckes","piruleta"]
        def result = graph.graphvizFollowers(users, commonFollowers)
        assert result != null
    }
    // void TestGraphRelationIFollowThem(){
    //     Graph graph = Graph()
    //     def grafo = graph.followThem()
    //     assert grafo != null
    // }
    // void TestGraphRelationWeFollowUs(){
    //     Graph graph = Graph()
    //     def grafo = graph.followUs()
    //     assert grafo != null
    // }
}
