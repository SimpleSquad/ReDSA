
package ListPkg;

//as the question says to implement listable interface with two methods
//named compareTo and copy we defined them here as abstract methods
//The concrete class of this is ListHouse

public interface Listable {
	
	public abstract String compareTo(Listable comparison);

	public abstract Listable copy();

}
