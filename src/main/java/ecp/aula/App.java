package ecp.aula;

public class App {
    public static void main(String[] args) {
        //Caso utilize outro banco de dados, não esquecer de adicionar a dependência no pom.xml
        ContatoDAO dao = new ContatoDAO();
        for(Contato c1: dao.findAll()){
            System.out.println(c1);
        }
    }
}
