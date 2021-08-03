import java.util.Random;

public class CompSciClass extends Class{

    private String language="";

    public CompSciClass(String[] DataForClass) {
        setData(DataForClass);
        setLanguage();
    }

    @Override
    public Integer getClassLevel() {
        return super.getClassLevel();
    }

    @Override
    public void PrintClassInformation(){
        super.PrintClassInformation();
        System.out.println(language);

    }

    private void setLanguage(){
        Random rand = new Random();
        int randInt = rand.nextInt(9-1)+1;
        switch (randInt){
            case 1: language ="Java";
                    break;
            case 2: language ="C++";
                    break;
            case 3: language ="Phyton";
                    break;
            case 4: language ="HTML";
                    break;
            case 5: language ="JavaScript";
                    break;
            case 6: language ="COBOL";
                    break;
            case 7: language ="x86 Assembly";
                    break;
            case 8: language = "C#";
                    break;
            case 9: language ="SQL";
                    break;
            default: language= "C";
                    break;
        }
    }

    public String returnClassProgrammingLanguage(){
        return ("Programming Language: "+language);
    }

}
