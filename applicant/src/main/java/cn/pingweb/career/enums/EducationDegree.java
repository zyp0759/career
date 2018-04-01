package cn.pingweb.career.enums;

public enum EducationDegree {

    DAZHUANG_BELLOW("1","大专以下"),
    DAZHUANG("2","大专"),
    BENKE("3","本科"),
    SHUOSHI("4", "硕士"),
    BOSHI("5", "博士");

    String degreeValue;
    String degreeName;

    EducationDegree(String degreeValue, String degreeName) {
        this.degreeValue = degreeValue;
        this.degreeName = degreeName;
    }

    public String getDegreeValue() {
        return degreeValue;
    }

    public void setDegreeValue(String degreeValue) {
        this.degreeValue = degreeValue;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public static String getDegreeNameByValue(String value) {
        String name = value;
        for (EducationDegree educationDegree : EducationDegree.values()) {
            if(educationDegree.getDegreeValue().equals(value)) {
                name = educationDegree.getDegreeName();
                break;
            }
        }
        return name;
    }
}
