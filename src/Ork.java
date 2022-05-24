public class Ork extends Postac{
    //atakuja tylko jak sa na tym samym polu

    public double skill_issue;      //co to robilo? obnizalo czy negowalo zadane dmg?
    public int chance_to_see;


    Ork(){
        skill_issue = rand.nextDouble();                //losuje od 0 do 1;
        chance_to_see = rand.nextInt(101);       //szansa na zobaczenie I guess
    }
}
