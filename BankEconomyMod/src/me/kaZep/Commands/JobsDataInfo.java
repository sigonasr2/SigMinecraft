package me.kaZep.Commands;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class JobsDataInfo {
	String jobname;
	String introstring;
	String actionname1;
	String actionname2;
	String actionname3;
	String actionname4;
	List<String> extrainfo;
	List<String> datanames1;
	List<String> datanames2;
	List<String> datanames3;
	List<String> datanames4;
	String lv5buff;
	String lv10buff;
	String lv20buff;
	String lv40buff;
	List<Double> dataprice1;
	List<Double> dataprice2;
	List<Double> dataprice3;
	List<Double> dataprice4;
	List<Double> dataexp1;
	List<Double> dataexp2;
	List<Double> dataexp3;
	List<Double> dataexp4;
	public double basexp;
	public double explvup;
	public double explvmult;
	public double moneymult;
	public JobsDataInfo() {
		jobname = "";
		introstring = "";
		actionname1 = "";
		actionname2 = "";
		actionname3 = "";
		actionname4 = "";
		extrainfo = new ArrayList<String>();
		datanames1 = new ArrayList<String>();
		datanames2 = new ArrayList<String>();
		datanames3 = new ArrayList<String>();
		datanames4 = new ArrayList<String>();
		lv5buff = "";
		lv10buff = "";
		lv20buff = "";
		lv40buff = "";
		dataprice1 = new ArrayList<Double>();
		dataprice2 = new ArrayList<Double>();
		dataprice3 = new ArrayList<Double>();
		dataprice4 = new ArrayList<Double>();
		dataexp1 = new ArrayList<Double>();
		dataexp2 = new ArrayList<Double>();
		dataexp3 = new ArrayList<Double>();
		dataexp4 = new ArrayList<Double>();
		basexp = 0;
		explvup = 0;
		explvmult = 0;
		moneymult = 0;
	}
	public void setJobName(String title) {
		this.jobname = title;
	}
	public void setJobDescription(String desc) {
		this.introstring = desc;
	}
	public void addExtraData(String info) {
		extrainfo.add(info);
	}
	public String getBuffData(int lv) {
		switch (lv) {
			case 5:{
				return this.lv5buff;
			}
			case 10:{
				return this.lv10buff;
			}
			case 20:{
				return this.lv20buff;
			}
			case 40:{
				return this.lv40buff;
			}
		}
		return "";
	}
	public void setBuffData(String lv5,String lv10,String lv20,String lv40) {
		this.lv5buff=lv5;
		this.lv10buff=lv10;
		this.lv20buff=lv20;
		this.lv40buff=lv40;
	}
	public void setAction(int numb, String name) {
		switch (numb) {
			case 0:{
				this.actionname1=name;
			}break;
			case 1:{
				this.actionname2=name;
			}break;
			case 2:{
				this.actionname3=name;
			}break;
			case 3:{
				this.actionname4=name;
			}break;
			default:{
				this.actionname1=name;
			}
		}
	}
	public void setExp(double base, double lvup, double lvmult, double moneymult) {
		this.basexp=base;
		this.explvup=lvup;
		this.explvmult=lvmult;
		this.moneymult=moneymult-1;
	}
	public void addData(String name, double price, double exp, int actionnumb) {
		switch (actionnumb) {
			case 0:{
				this.datanames1.add(name);
				this.dataprice1.add(price);
				this.dataexp1.add(exp);
			}break;
			case 1:{
				this.datanames2.add(name);
				this.dataprice2.add(price);
				this.dataexp2.add(exp);
			}break;
			case 2:{
				this.datanames3.add(name);
				this.dataprice3.add(price);
				this.dataexp3.add(exp);
			}break;
			case 3:{
				this.datanames4.add(name);
				this.dataprice4.add(price);
				this.dataexp4.add(exp);
			}break;
			default:{
				this.datanames1.add(name);
				this.dataprice1.add(price);
				this.dataexp1.add(exp);
			}
		}
	}
	public void sendOutput(Player p) {
        DecimalFormat df = new DecimalFormat("#0.00");
		p.sendMessage(this.jobname);
		p.sendMessage("");
		p.sendMessage(this.introstring);
		if (this.extrainfo!=null) {
			for (int i=0;i<this.extrainfo.size();i++) {
				p.sendMessage(ChatColor.YELLOW+this.extrainfo.get(i));
			}
		}
		if (this.datanames1!=null) {
			p.sendMessage("");
			p.sendMessage(this.actionname1+":");
			for (int i=0;i<this.datanames1.size();i++) {
				p.sendMessage(ChatColor.AQUA+"  "+this.datanames1.get(i)+ChatColor.WHITE +" - "+ChatColor.GOLD+"$ "+df.format(this.dataprice1.get(i)+0.00d)+" "+ChatColor.ITALIC+ChatColor.LIGHT_PURPLE+" "+Math.round(this.dataexp1.get(i))+"xp");
			}
		}
		if (this.datanames2!=null) {
			if (this.actionname2!="") {
				p.sendMessage("");
				p.sendMessage(this.actionname2+":");
				for (int i=0;i<this.datanames2.size();i++) {
					p.sendMessage(ChatColor.AQUA+"  "+this.datanames2.get(i)+ChatColor.WHITE +" - "+ChatColor.GOLD+"$ "+df.format(this.dataprice2.get(i))+" "+ChatColor.ITALIC+ChatColor.LIGHT_PURPLE+" "+Math.round(this.dataexp2.get(i))+"xp");
				}
			}
		}
		if (this.datanames3!=null) {
			if (this.actionname3!="") {
				p.sendMessage("");
				p.sendMessage(this.actionname3+":");
				for (int i=0;i<this.datanames3.size();i++) {
					p.sendMessage(ChatColor.AQUA+"  "+this.datanames3.get(i)+ChatColor.WHITE +" - "+ChatColor.GOLD+"$ "+df.format(this.dataprice3.get(i))+" "+ChatColor.ITALIC+ChatColor.LIGHT_PURPLE+" "+Math.round(this.dataexp3.get(i))+"xp");
				}
			}
		}
		if (this.datanames4!=null) {
			if (this.actionname4!="") {
				p.sendMessage("");
				p.sendMessage(this.actionname4+":");
				for (int i=0;i<this.datanames4.size();i++) {
					p.sendMessage(ChatColor.AQUA+"  "+this.datanames4.get(i)+ChatColor.WHITE +" - "+ChatColor.GOLD+"$ "+df.format(this.dataprice4.get(i))+" "+ChatColor.ITALIC+ChatColor.LIGHT_PURPLE+" "+Math.round(this.dataexp4.get(i))+"xp");
				}
			}
		}
		return;
	}
	public boolean sendOutput(Player p,int lv) {
		if (lv>0 && lv<=40) {
        DecimalFormat df = new DecimalFormat("#0.00");
		p.sendMessage(this.jobname);
		p.sendMessage("");
		p.sendMessage(this.introstring);
		if (this.extrainfo!=null) {
			for (int i=0;i<this.extrainfo.size();i++) {
				p.sendMessage(ChatColor.YELLOW+this.extrainfo.get(i));
			}
		}
		if (this.datanames1!=null) {
			p.sendMessage("");
			p.sendMessage(this.actionname1+":");
			for (int i=0;i<this.datanames1.size();i++) {
				p.sendMessage(ChatColor.AQUA+"  "+this.datanames1.get(i)+ChatColor.WHITE +" - "+ChatColor.GOLD+"$ "+df.format(this.dataprice1.get(i)*(1d+(moneymult*(lv-1))))+" "+ChatColor.ITALIC+ChatColor.LIGHT_PURPLE+" "+Math.round(this.dataexp1.get(i))+"xp");
			}
		}
		if (this.datanames2!=null) {
			if (this.actionname2!="") {
				p.sendMessage("");
				p.sendMessage(this.actionname2+":");
				for (int i=0;i<this.datanames2.size();i++) {
					p.sendMessage(ChatColor.AQUA+"  "+this.datanames2.get(i)+ChatColor.WHITE +" - "+ChatColor.GOLD+"$ "+df.format(this.dataprice2.get(i)*(1d+(moneymult*(lv-1))))+" "+ChatColor.ITALIC+ChatColor.LIGHT_PURPLE+" "+Math.round(this.dataexp2.get(i))+"xp");
				}
			}
		}
		if (this.datanames3!=null) {
			if (this.actionname3!="") {
				p.sendMessage("");
				p.sendMessage(this.actionname3+":");
				for (int i=0;i<this.datanames3.size();i++) {
					p.sendMessage(ChatColor.AQUA+"  "+this.datanames3.get(i)+ChatColor.WHITE +" - "+ChatColor.GOLD+"$ "+df.format(this.dataprice3.get(i)*(1d+(moneymult*(lv-1))))+" "+ChatColor.ITALIC+ChatColor.LIGHT_PURPLE+" "+Math.round(this.dataexp3.get(i))+"xp");
				}
			}
		}
		if (this.datanames4!=null) {
			if (this.actionname4!="") {
				p.sendMessage("");
				p.sendMessage(this.actionname4+":");
				for (int i=0;i<this.datanames4.size();i++) {
					p.sendMessage(ChatColor.AQUA+"  "+this.datanames4.get(i)+ChatColor.WHITE +" - "+ChatColor.GOLD+"$ "+df.format(this.dataprice4.get(i)*(1d+(moneymult*(lv-1))))+" "+ChatColor.ITALIC+ChatColor.LIGHT_PURPLE+" "+Math.round(this.dataexp4.get(i))+"xp");
				}
			}
		}
		return true;
		} else {
			if (lv<0 || lv>40) {
				p.sendMessage(ChatColor.RED+"Level must be between 1 and 40.");
			}
			return false;
		}
	}
}
