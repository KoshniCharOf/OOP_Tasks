package agency;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeSet;

import estates.Estate;



/**
 * Реализирайте структура от класове, която да представлява работата на агенция за недвижими
имоти в София.
 Агенцията съдържа следните характеристики:
• наименование;
• адрес;
• телефон за контакти;
В агенцията работят агенти, които отговарят за продажбата на имоти.
 *
 */
public class Agency {
	private String name;
	private String adress;
	private String phoneNumber;
	private ArrayList<Agent> agents;
	private double cash;
	
/*	Агенцията разполага с каталог с обяви, който съдържа всички имоти, регистрирани в нея.
	Имотите са категоризирани по вид (апартаменти, къщи, парцели), като за всяка категория
	подредбата е по цена в низходящ ред.*/
	
	private HashMap<String, TreeSet<Estate>> catalog;
	
	public void printCatalog(){
		for (Entry<String, TreeSet<Estate>> en : catalog.entrySet()) {
			System.out.println("===="+en.getKey()+"====");
			for (Estate e : en.getValue()) {
				System.out.println(e);
			}
		}
	}
	
	
	public Agency(String name) {
		super();
		if(name!=null){
			this.name = name;
		}else{
			this.name = "Таланти Естейтс";
		}
		this.catalog = new HashMap<>();
		this.agents =  new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			this.agents.add(new Agent("Vulturev "+i,this));
		}
	}
	
	
	
   // от	агенцията му се причислява агент на произволен принцип.
	public Agent asignAgent(){
		return this.agents.get(new Random().nextInt(this.agents.size()));
	}


	public void addEstate(Estate e) {
		if(!catalog.containsKey(e.getType())){
			catalog.put(e.getType(), new TreeSet<>());
		}
		catalog.get(e.getType()).add(e);
	}
	
	public void recieveMoneyFor(double money, Estate e){
		if(money>0){
			this.cash+=money/2;
			e.getAgent().recieveMoney(money/2);
		}
	}



	public HashMap<String, TreeSet<Estate>> getCatalog() {
		return catalog;
	}
	
	public void printBalance(){
		System.out.printf(this.name+" Balance %.2f Euro \n",this.cash);
	}
	
	public void printAgentsBalance(){
		Collections.sort(agents, (Agent o1, Agent o2) -> o2.getMoney()-o1.getMoney()>0?1:-1);
			//SECOND LAMBDA 
		
		for (Agent agent : agents) {
			System.out.printf(agent.getName()+" : %.2f \n",agent.getMoney());
		}
	}
}
