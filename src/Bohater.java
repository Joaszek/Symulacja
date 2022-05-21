public class Bohater extends Postac implements Refuse_to_eat{
    public void Eat(){};
    public int bonus_dmg_from_babcia;
    public int kills;
    public int look;
    public int magic;
    public boolean has_ring;
    public boolean has_babcia;
    public void magic_dmg(){};

    @Override
    public boolean Eat_or_die() {
        return false;
    }
}
