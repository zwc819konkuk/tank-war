package DP.builder;

/**
 * 构建复杂对象
 * 可以对属性进行分组
 */
public class Main {
    public static void main(String[] args) {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain t = builder.buildFort().buildMine().buildWall().build();

        Person p = new Person.PersonBuilder()
                .basicInfo(1, "zs", 10)
                .score(22)
                .weight(222)
                .loc("seoul", "22")
                .build();

    }
}
