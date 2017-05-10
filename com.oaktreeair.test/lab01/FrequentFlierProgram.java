package lab01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oaktreeair.ffprogram.BonusCalc;
import com.oaktreeair.ffprogram.ContactInfo;
import com.oaktreeair.ffprogram.Flier;
import com.oaktreeair.ffprogram.Flier.Level;
import com.oaktreeair.ffprogram.Segment;

public class FrequentFlierProgram {
	
	public static void main(String args[]){
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/spring.xml");
		Flier flier = (Flier)ctx.getBean("flier");
		
		System.out.println(flier.getFlierName());
		System.out.println(flier.getFlierID());
		ContactInfo contactInfo = flier.getContactInformation();
		System.out.println(contactInfo.getEmailAddress());
	    flier.setLevel(Level.Gold);
	    Segment seg = (Segment)ctx.getBean("seg01");
	    BonusCalc bonusCalc = (BonusCalc)ctx.getBean("calcBonus");
	    int bonus = bonusCalc.calcBonus(flier, seg);
	    System.out.println(bonus);
	    ctx.close();
	}

}
