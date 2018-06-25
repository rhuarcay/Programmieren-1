import static java.lang.Math.random;

public class SpecialWeapon extends Weapon implements SpecialWeaponInterface {
    private final int LOAD_TO_FIRE = 3;
    int amount;
    int arealDamage;
    int load = 0;

    public SpecialWeapon() {
        super();
        this.amount = 5;
        this.arealDamage = 3;
        this.offset = 20;
    }

    @Override
    public int calculateOffset(int distance) {
        return super.calculateOffset(distance);
    }

    @Override
    public int getATK() {
        return super.getATK();
    }

    @Override
    public boolean spendAmmunition() {
        return (--amount) > 0;
    }

    @Override
    public int arealDamage() {
        return arealDamage;
    }

    @Override
    public int getRadius() {
        return (int) (random() * 3);
    }

    @Override
    public int getLoadStatus() {
        return LOAD_TO_FIRE - load;
    }

    @Override
    public boolean load() {
        load++;
        if (load >= LOAD_TO_FIRE) {
            load = 0;
            return true;
        }
        return false;
    }
}
