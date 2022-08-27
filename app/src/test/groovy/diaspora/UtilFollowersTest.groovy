package diaspora

class UtilFollowersTest extends GroovyTestCase {
    void testGetFollowers(){
        def client = new UtilFollowers('https://api.github.com')
        def result = client.getFollowers('3rickDJ')
        assert result != null
        // assert result.contains( 'gHector6')
    }
    void TestGetCommonFollowers(){
        def client = new UtilFollowers('https://api.github.com')
        def users = ['3rickDJ', 'gHector6']
        def result = client.getCommonFollowers(users)
        assert result != null
        // assert result.contains('doguedogue')
    }
    void TestGetFollowRelation(){
        def client = new UtilFollowers('https://api.github.com')
        def commonFollowers = ["doguedogue", "hA1nn-dot", "PressureDraper", "HectorGbravo", "IsmaelCamna", "devleon00", "AliciaGaona", "victorsaucedom", "FabiMateosCat"]
        def result = client.getFollowRelation(commonFollowers)
        assert result != null
        // assert result.contains(['doguedogue':[]])
    }

}
