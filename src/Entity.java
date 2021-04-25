public interface Entity {

    public String getName();

    public String getDescription();

    public String getSpecies();

    public void move();

    public Graph.Node getRoom();
}
