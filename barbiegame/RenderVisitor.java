package barbiegame;

public class RenderVisitor implements EntityVisitor {
    StringBuilder sb = new StringBuilder();

    @Override
    public void visit(Barbie barbie) {
        sb.append("B");
    }

    @Override
    public void visit(Zombie zombie) {
        sb.append("Z");
    }

    @Override
    public void visit(Pear pear) {
        sb.append("P");
    }

    public String getResult() {
        return sb.toString();
    }
}

