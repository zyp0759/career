package cn.pingweb.career.dto;

public enum KeyWordsDto {

    ABCD("ABCD","Android"),
    EFG("EFG","E,F,Go"),
    HIJK("HIJK","Hive,JavaScript,Java,Kotlin"),
    LMN("LMN","Linux,Lua,MySQL,NoSQL"),
    OPQ("OPQ","Office,Oracle,PHP"),
    RST("RST","R,S,T"),
    UVW("UVW","Web"),
    XYZ("XYZ","X,Y,Z"),
    OTHER("自定义","其他1,其他2");

    String name;
    String values;

    KeyWordsDto(String name, String values) {
        this.name = name;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public String getValues() {
        return values;
    }
}
