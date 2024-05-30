package barbiegame;

public interface EntityVisitor {

    //visit Barbie
    void visit(Barbie barbie);

    //visit Zombie
    void visit(Zombie zombie);

    //visit Pear
    void visit(Pear pear);
}

