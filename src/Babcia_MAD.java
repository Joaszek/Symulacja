public class Babcia_MAD {
    public void feed(Postac someone){
              someone.hp= someone.MAX_HP;
    };   //leczy do max HP, jesli zje
    public void Instakill(boolean dies, Postac someone){
        if(dies)someone.hp=0;
    };  //jak odmowi to postac umiera //bruh

}
