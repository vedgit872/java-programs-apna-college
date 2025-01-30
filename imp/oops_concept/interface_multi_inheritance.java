package imp.oops_concept;

public class interface_multi_inheritance {
  public static void main(String[] args) {
    
      bear b=new bear();
      b.plants();
      b.meat();
    }     
}

interface herbivore{
    void plants();
}
interface carnivore{
    void meat();
}
class bear implements herbivore ,carnivore{
    public void plants(){
        System.out.println("i eat animals");

    }
    public void meat(){
        System.out.println("i eat meat");
    }
}