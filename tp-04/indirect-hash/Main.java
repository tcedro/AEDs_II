//hashTable
class Hash 
{
    public CellPers[] hashTable;
    public int size;
    

    public Hash(int size) {
        this.size = size;
        if(size >= 0){
            this.hashTable = new  CellPers[size];
            for (int i = 0; i < size; i++) {
                this.hashTable[i] = null;
            }
        }
    } 

    private int getHashCode(int persLen)    { return (persLen % 25);  }
    
    public boolean insert(Character pers) {
        int hashCode = getHashCode(pers.getAltura());

        if(this.hashTable[hashCode] == null) {
            this.hashTable[hashCode].setCharacter(pers);
            return true;
        
        } else {
            if(this.hashTable[hashCode] != null) {
                CellPers i;
            
                if(this.hashTable[hashCode].next == null) {
                this.hashTable[hashCode].next = new CellPers(pers);
            } else {
                for (i = this.hashTable[hashCode].next; i != null; i = i.next);
                i.next = new CellPers(pers);

            }
                return true;
            }
        }
           

        return false;
    }

    // public boolean search(String namePers) {
    //     for (int i = 0; i < size; i++) {
    //         if( hashTable[i] != null )  { 
    //             if(hashTable[i].getNome().compareTo(namePers) == 0) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    public void showHashTable() {
        int i = 0;

        while(i < size) {
            if(this.hashTable[i] != null) {
                MyIO.println("[" + i + "] " + this.hashTable[i].element.getNome());
                
                if(this.hashTable[i].hasNext()) {
                    CellPers x = this.hashTable[i].next;
                    while (x != null) {
                        MyIO.println("[" + i + "] - reserve list: " + x.element.getNome());
                        x = x.next;
                    }
                }
            }
            
            i++;
        }
    }
    
}



//----------------------------Celula Character------------------------------//

class CellPers 
{
    public Character element;
    public CellPers next;

    CellPers() { this(null); }
    
    CellPers(Character pers) {
        this.element = pers;
        this.next = null;
    }

    public void setCharacter(Character pers) { this.element = pers; }
    public void setNext(Character pers) { this.next = new CellPers(pers); }
    public boolean hasNext() { return next != null; }
}


//-------------------------------Character ----------------------------------//

class Character 
{
    //----------------------------atributes----------------------------------//

    private String nome;
    private int    altura;
    private double peso;
    private String corDoCabelo;
    private String CorDaPele;
    private String corDosOlhos;
    private String anoNascimento;
    private String genero;
    private String homeworld;

    //----------------------------constructors-------------------------------//

    /*
        Default
    */
    Character() {
        this.nome = ""; 
        this.altura = 0;
        this.peso = 0.0; 
        this.corDoCabelo = "";
        this.CorDaPele = "";
        this.corDosOlhos = "";
        this.anoNascimento = "";
        this.genero = "";
        this.homeworld = "";
    }
    
    /*
        Parameters
    */
    Character(String nome, int altura, double peso, String corDoCabelo, String corDaPele,
              String corDosOlhos, String anoNascimento, String genero, String homeworld) {
        this.nome = nome; 
        this.altura = altura;
        this.peso = peso; 
        this.corDoCabelo = corDoCabelo;
        this.CorDaPele = corDaPele;
        this.corDosOlhos = corDosOlhos;
        this.anoNascimento = anoNascimento;
        this.genero = genero;
        this.homeworld = homeworld;
    }

    //----------------------------getters----------------------------------//

    public String getNome()          { return this.nome; }
    public int    getAltura()        { return this.altura; }
    public double getPeso()          { return this.peso; }
    public String getCorDoCabelo()   { return this.corDoCabelo; }
    public String getCorDaPele()     { return this.CorDaPele; }
    public String getCorDosOlhos()   { return this.corDosOlhos; }
    public String getAnoNascimento() { return this.anoNascimento; }
    public String getGenero()        { return this.genero; }
    public String getHomeWorld()     { return this.homeworld; }

    //----------------------------setters----------------------------------//

    public void setNome(String nome)                    {  this.nome = nome; }
    public void setAltura(int altura)                   {  this.altura = altura; }
    public void setPeso(double peso)                    {  this.peso = peso; }
    public void setCorDoCabelo(String corDoCabelo)      {  this.corDoCabelo = corDoCabelo; }
    public void setCorDaPele(String corDaPele)          {  this.CorDaPele = corDaPele; }
    public void setCorDosOlhos(String corDosOlhos)      {  this.corDosOlhos = corDosOlhos; }
    public void setAnoNascimento(String anoNascimentos) {  this.anoNascimento = anoNascimentos; }
    public void setGenero(String genero)                {  this.genero = genero; }
    public void setHomeWorld(String homeworld)          {  this.homeworld = homeworld; }

    //------------------------------clone--------------------------------//

    public Character clone() {
        Character clone = new Character();

        clone.setAltura        (this.getAltura());
        clone.setAnoNascimento (this.getAnoNascimento()); 
        clone.setCorDaPele     (this.getCorDaPele());
        clone.setCorDoCabelo   (this.getCorDoCabelo());
        clone.setCorDosOlhos   (this.getCorDosOlhos());
        clone.setGenero        (this.getGenero());
        clone.setHomeWorld     (this.getHomeWorld());
        clone.setNome          (this.getNome());
        clone.setPeso          (this.getPeso());

        return clone;
    }

    //------------------------------toString--------------------------------//

    public String toString() {
        return " ## " + this.getNome() + " ## " + this.getAltura() + " ## " + this.getPeso() + " ## " + this.getCorDoCabelo()  +
         " ## " + this.getCorDaPele() + " ## " + this.getCorDosOlhos() + " ## " + this.getAnoNascimento() + " ## " +
         this.getGenero() + " ## " + this.getHomeWorld() + " ## ";
    }

    //compare
    public int compare(Character pers2) {
        int resp = -1;
        if (pers2 != null) resp = this.getNome().compareTo(pers2.getNome());
        return resp;
    }

} 
//----------------------------FileManagement-----------------------------//

class FileManagement
{
    //------------------------------atributos-----------------------------------//

    public String pathFile;
    public String contentFile;

    //------------------------------readFile---------------------------------//
    
    public void readFile() {
        Arq.openRead(this.pathFile);
        this.contentFile = Arq.readLine();
        Arq.close();
    }

    //---------------------------Separar-valor-do-Nome------------------------//
    public String separarNome() {
        int indiceDoAtributo = this.contentFile.indexOf("'name'") + 9;
        String name = "";
        while (this.contentFile.charAt(indiceDoAtributo) != 39) {
            name += contentFile.charAt(indiceDoAtributo);
            indiceDoAtributo++;
        }
        
        return name;
    }

    //-----------------------------Separar-Altura----------------------------//

    public String separarAltura() {
        int indiceDoAtributo = this.contentFile.indexOf("'height'") + 11;
        String altura = "";
        while (this.contentFile.charAt(indiceDoAtributo) != 39) {
            altura += contentFile.charAt(indiceDoAtributo);
            indiceDoAtributo++;
        }
        if(altura.equals("unknown")) altura = "0";
        return altura;
    }

    public int separarPeso() {
        int indiceDoAtributo = this.contentFile.indexOf("'mass'") + 9;
        String peso = "";
        while (this.contentFile.charAt(indiceDoAtributo) != 39) {
            if (contentFile.charAt(indiceDoAtributo) == ',') {
                peso += '.'; 
                indiceDoAtributo++;
                continue;
            }
            
            peso += contentFile.charAt(indiceDoAtributo);
            indiceDoAtributo++;
        }
        if (peso.equals("unknown")) {
            return 0;
        } else {
            double pesoDouble = Double.parseDouble(peso);
            if (Math.floor(pesoDouble) == pesoDouble) {
                return (int) pesoDouble;
            } else {
                return (int) Math.round(pesoDouble);
            }
        }
    }

    //---------------------------Separar-Cor-Do-Cabelo----------------------//

    public String separarCorDoCabelo() {
        int indiceDoAtributo = this.contentFile.indexOf("'hair_color'") + 15;
        String corDoCabelo = "";
        while (this.contentFile.charAt(indiceDoAtributo) != 39) {
            corDoCabelo += contentFile.charAt(indiceDoAtributo);
            indiceDoAtributo++;
        }
        return corDoCabelo;
    }

    //-----------------------separar-cor-da-pele-------------------------//

    public String separarCorDaPele() {
        int indiceDoAtributo = this.contentFile.indexOf("'skin_color'") + 15;
        String corDaPele = "";
        while (this.contentFile.charAt(indiceDoAtributo) != 39) {
            corDaPele += contentFile.charAt(indiceDoAtributo);
            indiceDoAtributo++;
        }
        return corDaPele;
    }

    //-----------------------separar-cor-dos-olhos-------------------//

    public String separarCorDosOlhos() {
        int indiceDoAtributo = this.contentFile.indexOf("'eye_color'") + 14;
        String corDosOlhos = "";
        while (this.contentFile.charAt(indiceDoAtributo) != 39) {
            corDosOlhos += contentFile.charAt(indiceDoAtributo);
            indiceDoAtributo++;
        }
        return corDosOlhos;
    }

    //-----------------------data-de-nascimento---------------------//

    public String separarDataNascimento() {
        int indiceDoAtributo = this.contentFile.indexOf("'birth_year'") + 15;
        String dataNascimento = "";
        while (this.contentFile.charAt(indiceDoAtributo) != 39) {
            dataNascimento += contentFile.charAt(indiceDoAtributo);
            indiceDoAtributo++;
        }
        return dataNascimento;
    }

    //------------------------separar-genero-----------------------//
    
    public String separarGenero() {
        int indiceDoAtributo = this.contentFile.indexOf("'gender'") + 11;
        String genero = "";
        while (this.contentFile.charAt(indiceDoAtributo) != 39) {
            genero += contentFile.charAt(indiceDoAtributo);
            indiceDoAtributo++;
        }
        return genero;
    }

    //----------------------separar-homeworld---------------------//

    public String separarHomeworld() {
        int indiceDoAtributo = this.contentFile.indexOf("'homeworld'") + 14;
        String homeworld = "";
        while (this.contentFile.charAt(indiceDoAtributo) != 39) {
            homeworld += contentFile.charAt(indiceDoAtributo);
            indiceDoAtributo++;
        }
        return homeworld;
    }

    //----------------------set atributos personagem--------------------------//

    public void setAtributosPersonagem(Character pers) {
        pers.setNome           ( this.separarNome() );
        pers.setAltura         ( Integer.parseInt( this.separarAltura() ));
        pers.setPeso           ( this.getPeso() );
        pers.setCorDaPele      ( this.separarCorDaPele() );
        pers.setCorDoCabelo    ( this.separarCorDoCabelo() );
        pers.setCorDosOlhos    ( this.separarCorDosOlhos() );
        pers.setAnoNascimento  ( this.separarDataNascimento() );
        pers.setGenero         ( this.separarGenero() );
        pers.setHomeWorld      ( this.separarHomeworld() );      
            
    }

    //------------------------------setters-------------------------------//
    
    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    //------------------------------getters-----------------------------------//

    public String getNome() { 
        String nome = this.separarNome();
        return nome; 
    }
    public int getAltura() { 
        int altura = Integer.parseInt( this.separarAltura() );         
        return altura; 
    }
    public double getPeso() { 
        double peso = this.separarPeso();
        return peso; 
    }
    public String getCorDoCabelo() { 
        String corDoCabelo = this.separarCorDoCabelo();    
        return corDoCabelo;
    }
    public String getCorDaPele() { 
        String corDaPele = this.separarCorDaPele();    
        return corDaPele; 
    }
    public String getCorDosOlhos() { 
        String corDosOlhos = this.separarCorDosOlhos();
        return corDosOlhos;
    }
    public String getAnoNascimento() { 
        String anoNascimento = this.separarDataNascimento();
        return anoNascimento; 
    }
    public String getGenero() { 
        String genero = this.separarGenero();          
        return genero; 
    }
    public String getHomeWorld() { 
        String homeworld = this.separarHomeworld();    
        return homeworld; 
    }
}

class Main 
{
    //--------------------------------isFim--------------------------------//
    
    public static boolean isFim(String str) { return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'); }

    //--------------------------------main----------------------------------//
    public static void main(String[] args) throws Exception {
        //objetos
        Hash hashFormat = new Hash(25);
        FileManagement file = new FileManagement(); 

        //leitura de objetos (personagen)
        do { 
            file.pathFile = MyIO.readLine();
            if(isFim(file.pathFile)) break;
            
            Character pers = new Character();
            
            file.readFile();
            file.setAtributosPersonagem(pers);

            hashFormat.insert(pers);

        } while (true);

        hashFormat.showHashTable();

        // // persquina na arvore
        // do { 
        //     //ler nome de personagem a ser procurado
        //     String nomePers = MyIO.readLine();
        //     if(isFim(nomePers)) break;
            
        //     MyIO.print(nomePers + ' ');
        //     MyIO.println(hashFormat.search(nomePers)? "SIM":"NÃO");

        // } while (true);
    }
}