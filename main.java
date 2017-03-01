import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.awt.*;

import javax.imageio.ImageIO;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.randoms.RandomEvent;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.Category;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.methods.input.Keyboard;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.utilities.impl.Condition;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.wrappers.interactive.Player;
import org.dreambot.api.wrappers.widgets.message.Message;
@ScriptManifest(author = "Rotten", name = "EZNS opep", version = 1.0, description = "sb", category = Category.COMBAT)
public class main extends AbstractScript {
	private Image mainPaint = getImage("https://i.imgur.com/HyHHe5d.png");
	Area generalArea = new Area(3310, 4759, 3350, 4751, 0);
	Area PortalArea = new Area(3326, 4768, 3334, 4761, 0);
	Area AvoidaArea = new Area(3280, 4838, 3370, 4780, 0);
	Area AvoidbArea = new Area(3276, 4769, 3320, 4796, 0);
	Area AvoidcArea = new Area(3346, 4753, 3377, 4848, 0);
	Area permArea = new Area(3318, 4760, 3340, 4776, 0);
	private final Rectangle p = new Rectangle(565, 213, 20, 20);
	private long timeBegan;
	private long timeRan;
	//	private Keyboard kb;
	private int beginningXp;
	private int currentXp;
	private int xpGained;
	private long startTime;

	public void onStart() {

		getRandomManager().disableSolver(RandomEvent.DISMISS);
		startTime = System.currentTimeMillis();
		getSkillTracker().start();



		timeBegan = System.currentTimeMillis();
		beginningXp = getSkills().getExperience(Skill.STRENGTH);
		beginningXp = getSkills().getExperience(Skill.HITPOINTS);
	}


	private static final Font font1 = new Font("Arial", 1, 12);

	public void onPaint(Graphics g)
	{
		long runtime = (System.currentTimeMillis() - startTime)/1000;
		long xpGained = getSkillTracker().getGainedExperience(Skill.ATTACK) + getSkillTracker().getGainedExperience(Skill.STRENGTH) + getSkillTracker().getGainedExperience(Skill.DEFENCE) + getSkillTracker().getGainedExperience(Skill.RANGED) + getSkillTracker().getGainedExperience(Skill.MAGIC) + getSkillTracker().getGainedExperience(Skill.HITPOINTS);
		g.setColor(Color.WHITE);
		g.setFont(font1);
		g.drawImage(mainPaint, 0, 339, null);
		g.drawString("XP Gained (Hr): " + xpGained + " (" + (int)(xpGained*(3600/(double)runtime)) + ")", 8, 312);
		g.drawString("Time running: " + String.format("%02d:%02d:%02d", runtime / 3600, (runtime % 3600) / 60, runtime % 60), 8, 332);
	}


	private Image getImage(String url){
		try {
			return ImageIO.read(new URL(url));
		}catch (IOException e){
			return null;
		}
	}

	private String ft(long duration)
	{
		String res = "";
		long days = TimeUnit.MILLISECONDS.toDays(duration);
		long hours = TimeUnit.MILLISECONDS.toHours(duration)
				- TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
				- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
						.toHours(duration));
		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)
				- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
						.toMinutes(duration));
		if (days == 0) {
			res = (hours + ":" + minutes + ":" + seconds);
		} else {
			res = (days + ":" + hours + ":" + minutes + ":" + seconds);
		}
		return res;

	}





	public void onExit() {

	}


	// public boolean amIForeverAlone(){
	//    return getPlayers().all().size() <= 1;
	//    }

	private void perm(){
		// Player other = getPlayers().closest(p -> p.getName().contains(gui.getPermy()));
		//Player other = getPlayers().closest("Spongy");
		Player other = getPlayers().closest(p -> p.getName().contains("uWet"));
		if (!getLocalPlayer().isInCombat()){
			if(!(getLocalPlayer().getAnimation() == 836))


				if(other != null) {
					if (permArea.contains(other)) {
						if (!other.isInCombat()){
							other.interact("Attack");

						}
					}
				}
		}
	}
	private void perm1(){
		// Player other = getPlayers().closest(p -> p.getName().contains(gui.getPermy()));
		//Player other = getPlayers().closest("Spongy");
		Player other = getPlayers().closest(p -> p.getName().contains("Feelin"));
		if (!getLocalPlayer().isInCombat()){
			if(!(getLocalPlayer().getAnimation() == 836))


				if(other != null) {
					if (permArea.contains(other)) {
						if (!other.isInCombat()){
							other.interact("Attack");

						}
					}
				}
		}
	}

	private void perm2(){
		// Player other = getPlayers().closest(p -> p.getName().contains(gui.getPermy()));
		//	Player other = getPlayers().closest("Simply");
		Player other = getPlayers().closest(p -> p.getName().contains("Simply"));
		if (!getLocalPlayer().isInCombat()){
			if(!(getLocalPlayer().getAnimation() == 419)){
				if(!(getLocalPlayer().getAnimation() == 420)){
					if(!(getLocalPlayer().getAnimation() == 836)){

						if(other != null) {

							if (permArea.contains(other)) {
								if (!other.isInCombat()){
									other.interact("Attack");

								}
							}

						}
					}
				}
			}
		}
	}
	private void perm3(){
		// Player other = getPlayers().closest(p -> p.getName().contains(gui.getPermy()));
		Player other = getPlayers().closest("idiet");
		//Player other = getPlayers().closest(p -> p.getName().contains("Sxc"));
		if (!getLocalPlayer().isInCombat()){
			if(!(getLocalPlayer().getAnimation() == 419)){
				if(!(getLocalPlayer().getAnimation() == 420)){
					if(!(getLocalPlayer().getAnimation() == 836)){

						if(other != null) {

							if (permArea.contains(other)) {
								if (!other.isInCombat()){
									other.interact("Attack");

								}
							}

						}
					}
				}
			}
		}
	}
	private void perm4(){
		// Player other = getPlayers().closest(p -> p.getName().contains(gui.getPermy()));
		//	Player other = getPlayers().closest("Spongy");
		Player other = getPlayers().closest(p -> p.getName().contains("Rail"));
		if (!getLocalPlayer().isInCombat()){
			if(!(getLocalPlayer().getAnimation() == 836))


				if(other != null) {
					if (permArea.contains(other)) {
						if (!other.isInCombat()){
							other.interact("Attack");

						}
					}
				}
		}
	}
	private void perm5(){
		// Player other = getPlayers().closest(p -> p.getName().contains(gui.getPermy()));
		//	Player other = getPlayers().closest("Spongy");
		Player other = getPlayers().closest(p -> p.getName().contains("MARCO"));
		if (!getLocalPlayer().isInCombat()){
			if(!(getLocalPlayer().getAnimation() == 836))


				if(other != null) {
					if (permArea.contains(other)) {
						if (!other.isInCombat()){
							other.interact("Attack");
						}
					}
				}

		}
	}
	private void perm6(){
		// Player other = getPlayers().closest(p -> p.getName().contains(gui.getPermy()));
		Player other = getPlayers().closest("Arda");
		//Player other = getPlayers().closest(p -> p.getName().contains("MARCO"));
		if (!getLocalPlayer().isInCombat()){
			if(!(getLocalPlayer().getAnimation() == 836))


				if(other != null) {
					if (permArea.contains(other)) {
						if (!other.isInCombat()){
							other.interact("Attack");

						}
					}
				}
		}
	}
	private void perm7(){
		// Player other = getPlayers().closest(p -> p.getName().contains(gui.getPermy()));
		//	Player other = getPlayers().closest("Spongy");
		Player other = getPlayers().closest(p -> p.getName().contains("Exile"));
		if (!getLocalPlayer().isInCombat()){
			if(!(getLocalPlayer().getAnimation() == 836))


				if(other != null) {

					if (permArea.contains(other)) {
						if (!other.isInCombat()){
							other.interact("Attack");

						}
					}

				}
		}
	}
	private void earro(){
		if (getInventory().contains("Iron arrow")){
			sleep (1122,4444);
			getMouse().move(p);
			sleep(10, 80);
			getMouse().click();
			sleep(10, 80);
		}
	}



	//	@Override
	//public void onMessage(Message m) {
	//	if (m.getMessage().contains("Flexfannysmelly")) {
	//		log("Flex is a spastic");
	//	stop();
	//	}

	//	}


	@Override
	public int onLoop() {	


				perm();
		perm1();
		perm2();
			perm3();
		//perm4();
		//	perm5();
		//		perm7();
		//	perm6();
		GameObject stall = getGameObjects().closest("Free-for-all portal");
		if (stall != null) {
			stall.interact("Enter");



			Random srand = new Random();
			double chances = srand.nextDouble();
			if(chances < 0.096){
				log("Antiban; changing camera angle...");
				getCamera().rotateToEvent(srand.nextInt()+360,srand.nextInt()+90);
			} else {
			}

			sleep(5867,8720); 
			if(generalArea.contains(getPlayers().localPlayer().getTile())) {
				sleep(822,2219);
				//getPrayer().toggleQuickPrayer(true);	
				//sleep(622,1519);
				///Walk to a random tile inside the portal area
				log("Walking to the middle");
				Tile[] tiles = PortalArea.getTiles();
				Tile randomTile = tiles[Calculations.random(0, tiles.length - 1)];
				if (randomTile != null) {
					getWalking().walk(randomTile);
					sleep(1592,3200);
					sleepUntil(new Condition() {
						public boolean verify() {
							return PortalArea.contains(getPlayers().localPlayer()
									.getTile());




						}
					}, Calculations.random(1600, 1800));

				}
			}
		}

		if(AvoidaArea.contains(getPlayers().localPlayer().getTile())) {
			log("nicetrya");

			Tile[] tiles1 = PortalArea.getTiles();
			Tile randomTile1 = tiles1[Calculations.random(0, tiles1.length - 1)];
			if (randomTile1 != null) 
				getWalking().walk(randomTile1);
		}

		if(generalArea.contains(getPlayers().localPlayer().getTile())) {
			log("nicetrysafe");
			earro();
			Tile[] tiles1 = PortalArea.getTiles();
			Tile randomTile1 = tiles1[Calculations.random(0, tiles1.length - 1)];
			if (randomTile1 != null) 
				getWalking().walk(randomTile1);





		}

		if(AvoidbArea.contains(getPlayers().localPlayer().getTile())) {
			log("nicetryb");
			Tile[] tiles1 = PortalArea.getTiles();
			Tile randomTile1 = tiles1[Calculations.random(0, tiles1.length - 1)];
			if (randomTile1 != null) 
				getWalking().walk(randomTile1);




		}
		if(AvoidcArea.contains(getPlayers().localPlayer().getTile())) {
			log("nicetryc");
			Tile[] tiles1 = PortalArea.getTiles();
			Tile randomTile1 = tiles1[Calculations.random(0, tiles1.length - 1)];
			if (randomTile1 != null) 
				getWalking().walk(randomTile1);




		}
		//if (getPlayers().all().size() < 2) {
		//	if(!getTabs().isOpen(Tab.MAGIC))
		//	getTabs().open(Tab.MAGIC);
		//  } else {
		//	getMouse().move(p);
		//	sleep(10, 60);
		//	getMouse().click();
		//	sleep(10, 60);

		//}




		return Calculations.random(500, 600);
	}	



}
