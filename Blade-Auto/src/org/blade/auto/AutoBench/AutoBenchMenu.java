package org.blade.auto.AutoBench;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.blade.auto.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class AutoBenchMenu implements Listener{
	private Main plugin=Main.getPlugin(Main.class);
	//public boolean allowaccess=true;
	
	public void generateAutoTable(int x,int y,int z,Player player) {
		Inventory i=plugin.getServer().createInventory(null,27,"Auto Bench,"+x+","+y+","+z);
		ItemStack confirm=new ItemStack(Material.EMERALD);
		ItemMeta meta1=confirm.getItemMeta();
		meta1.setDisplayName(ChatColor.GREEN+"CONFIRM");
		confirm.setItemMeta(meta1);
		
		ItemStack clear=new ItemStack(Material.REDSTONE);
		ItemMeta meta2=clear.getItemMeta();
		meta2.setDisplayName(ChatColor.RED+"CLEAR");
		clear.setItemMeta(meta2);
		
		ItemStack separater=new ItemStack(Material.END_ROD);
		ItemMeta meta3=separater.getItemMeta();
		meta3.setDisplayName(ChatColor.GREEN+"<--Place Recipe that side");
		separater.setItemMeta(meta3);
		
		ItemStack getter=new ItemStack(Material.STONE_BUTTON);
		ItemMeta meta4=getter.getItemMeta();
		meta4.setDisplayName(ChatColor.GOLD+"Get all things in the bench");
		getter.setItemMeta(meta4);
		
		ItemStack viewer=new ItemStack(Material.WOOD_BUTTON);
		ItemMeta meta5=viewer.getItemMeta();
		meta5.setDisplayName(ChatColor.GOLD+"View all things in the bench");
		viewer.setItemMeta(meta5);
		
		i.setItem(3, separater);
		i.setItem(12, separater);
		i.setItem(21, separater);
		i.setItem(8, confirm);
		i.setItem(26, clear);
		i.setItem(25, getter);
		i.setItem(7, viewer);
		if(!plugin.getcfmg().getTable().getString("Table."+x+","+y+","+z+".Recipe.0.item").equals("")) {
		ItemStack slot0=(ItemStack)plugin.getcfmg().getTable().get("Table."+x+","+y+","+z+".Recipe.0.item");
		slot0.setAmount(1);
		i.setItem(0, slot0);
		}
		if(!plugin.getcfmg().getTable().getString("Table."+x+","+y+","+z+".Recipe.1.item").equals("")) {
		ItemStack slot1=(ItemStack)plugin.getcfmg().getTable().get("Table."+x+","+y+","+z+".Recipe.1.item");
		slot1.setAmount(1);
		i.setItem(1, slot1);
		}
		if(!plugin.getcfmg().getTable().getString("Table."+x+","+y+","+z+".Recipe.2.item").equals("")) {
		ItemStack slot2=(ItemStack)plugin.getcfmg().getTable().get("Table."+x+","+y+","+z+".Recipe.2.item");
		slot2.setAmount(1);
		i.setItem(2, slot2);
		}
		if(!plugin.getcfmg().getTable().getString("Table."+x+","+y+","+z+".Recipe.3.item").equals("")) {
		ItemStack slot3=(ItemStack)plugin.getcfmg().getTable().get("Table."+x+","+y+","+z+".Recipe.3.item");
		slot3.setAmount(1);
		i.setItem(9, slot3);
		}
		if(!plugin.getcfmg().getTable().getString("Table."+x+","+y+","+z+".Recipe.4.item").equals("")) {
		ItemStack slot4=(ItemStack)plugin.getcfmg().getTable().get("Table."+x+","+y+","+z+".Recipe.4.item");
		slot4.setAmount(1);
		i.setItem(10, slot4);
		}
		if(!plugin.getcfmg().getTable().getString("Table."+x+","+y+","+z+".Recipe.5.item").equals("")) {
		ItemStack slot5=(ItemStack)plugin.getcfmg().getTable().get("Table."+x+","+y+","+z+".Recipe.5.item");
		slot5.setAmount(1);
		i.setItem(11, slot5);
		}
		if(!plugin.getcfmg().getTable().getString("Table."+x+","+y+","+z+".Recipe.6.item").equals("")) {
		ItemStack slot6=(ItemStack)plugin.getcfmg().getTable().get("Table."+x+","+y+","+z+".Recipe.6.item");
		slot6.setAmount(1);
		i.setItem(18, slot6);
		}
		if(!plugin.getcfmg().getTable().getString("Table."+x+","+y+","+z+".Recipe.7.item").equals("")) {
		ItemStack slot7=(ItemStack)plugin.getcfmg().getTable().get("Table."+x+","+y+","+z+".Recipe.7.item");
		slot7.setAmount(1);
		i.setItem(19, slot7);
		}
		if(!plugin.getcfmg().getTable().getString("Table."+x+","+y+","+z+".Recipe.8.item").equals("")) {
		ItemStack slot8=(ItemStack)plugin.getcfmg().getTable().get("Table."+x+","+y+","+z+".Recipe.8.item");
		slot8.setAmount(1);
		i.setItem(20, slot8);
		}
		if(!plugin.getcfmg().getTable().getString("Table."+x+","+y+","+z+".Recipe.result.item").equals("")) {
			ItemStack slot9=(ItemStack)plugin.getcfmg().getTable().get("Table."+x+","+y+","+z+".Recipe.result.item");
			i.setItem(13, slot9);
		}
		player.openInventory(i);
		
	}
	@EventHandler
	public void onDragMenu(InventoryDragEvent e) {
		//if(!allowaccess) {return;}
		if(!e.getInventory().getName().contains("Auto Bench")) {
			return;
		}else {
			
				e.setCancelled(true);
	
		}
	}
	@EventHandler
	public void onClickMenu(InventoryClickEvent e) {
		//if(!allowaccess) {return;}
		if(e.getSlotType().equals(SlotType.OUTSIDE)) {return;}
		if(!e.getClickedInventory().getName().contains("Auto Bench")) {
			return;
		}else {
			if(e.getClick()==ClickType.CONTROL_DROP||e.getClick()==ClickType.CREATIVE||e.getClick()==ClickType.DOUBLE_CLICK||e.getClick()==ClickType.DROP||e.getClick()==ClickType.LEFT||e.getClick()==ClickType.MIDDLE||e.getClick()==ClickType.NUMBER_KEY||e.getClick()==ClickType.RIGHT||e.getClick()==ClickType.SHIFT_LEFT||e.getClick()==ClickType.SHIFT_RIGHT||e.getClick()==ClickType.UNKNOWN||e.getClick()==ClickType.WINDOW_BORDER_LEFT||e.getClick()==ClickType.WINDOW_BORDER_RIGHT) {
				e.setCancelled(true);
			}
			String[] strarr=e.getClickedInventory().getName().split(",");
			//e.setCancelled(true);
			//start doing crazy staff
			//inventory slot
			if(e.getSlot()==0||e.getSlot()==1||e.getSlot()==2||e.getSlot()==9||e.getSlot()==10||e.getSlot()==11||e.getSlot()==18||e.getSlot()==19||e.getSlot()==20) {
				popoutstuff(new Location(e.getWhoClicked().getLocation().getWorld(),Integer.parseInt(strarr[1]),Integer.parseInt(strarr[2]),Integer.parseInt(strarr[3])));
				if(e.getCursor()==null) {
					return;
				}else {
					ItemStack itemstack=e.getCursor().clone();
					itemstack.setAmount(1);
					e.setCurrentItem(itemstack);
				}
			}else if(e.getSlot()==7){//viewer
				e.getWhoClicked().sendMessage(ChatColor.GOLD+"=Item Inside the AutoBench========================");
				for(int i=0;i<9;i++) {
					if(plugin.getcfmg().getTable().getInt("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe."+i+".count")!=0) {
						ItemStack is=(ItemStack)plugin.getcfmg().getTable().get("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe."+i+".item");
						is.setAmount(plugin.getcfmg().getTable().getInt("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe."+i+".count"));
						e.getWhoClicked().sendMessage(ChatColor.GOLD+"row:"+(i/3+1)+" col:"+(i%3+1)+ChatColor.WHITE+" "+is);
					}else {
						e.getWhoClicked().sendMessage(ChatColor.GOLD+"row:"+(i/3+1)+" col:"+(i%3+1)+ChatColor.WHITE+" null");
					}
				}
				e.getWhoClicked().sendMessage(ChatColor.GOLD+"==================================================");
				e.getWhoClicked().closeInventory();
			}else if(e.getSlot()==25){//getter
				popoutstuff(new Location(e.getWhoClicked().getLocation().getWorld(),Integer.parseInt(strarr[1]),Integer.parseInt(strarr[2]),Integer.parseInt(strarr[3])));
				e.getWhoClicked().closeInventory();
			}else if(e.getSlot()==8){
				//verify recipe
				//getMateriallist get recipe
				ItemStack[][] myMatric=new ItemStack[3][3];
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						myMatric[i][j]=null;
					}
				}
				if(e.getClickedInventory().getItem(0)!=null) {
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.0.item",e.getClickedInventory().getItem(0));
					myMatric[0][0]=e.getClickedInventory().getItem(0);
				}else{
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.0.item","");
				}
				if(e.getClickedInventory().getItem(1)!=null) {
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.1.item",e.getClickedInventory().getItem(1));
					myMatric[0][1]=e.getClickedInventory().getItem(1);
				}else{
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.1.item","");
				}
				if(e.getClickedInventory().getItem(2)!=null) {
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.2.item",e.getClickedInventory().getItem(2));
					myMatric[0][2]=e.getClickedInventory().getItem(2);
				}else{
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.2.item","");
				}
				if(e.getClickedInventory().getItem(9)!=null) {
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.3.item",e.getClickedInventory().getItem(9));
					myMatric[1][0]=e.getClickedInventory().getItem(9);
				}else{
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.3.item","");
				}
				if(e.getClickedInventory().getItem(10)!=null) {
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.4.item",e.getClickedInventory().getItem(10));
					myMatric[1][1]=e.getClickedInventory().getItem(10);
				}else{
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.4.item","");
				}
				if(e.getClickedInventory().getItem(11)!=null) {
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.5.item",e.getClickedInventory().getItem(11));
					myMatric[1][2]=e.getClickedInventory().getItem(11);
				}else{
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.5.item","");
				}
				if(e.getClickedInventory().getItem(18)!=null) {
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.6.item",e.getClickedInventory().getItem(18));
					myMatric[2][0]=e.getClickedInventory().getItem(18);
				}else{
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.6.item","");
				}
				if(e.getClickedInventory().getItem(19)!=null) {
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.7.item",e.getClickedInventory().getItem(19));
					myMatric[2][1]=e.getClickedInventory().getItem(19);
				}else{
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.7.item","");
				}
				if(e.getClickedInventory().getItem(20)!=null) {
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.8.item",e.getClickedInventory().getItem(20));
					myMatric[2][2]=e.getClickedInventory().getItem(20);
				}else{
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.8.item","");
				}
				boolean found=false;
				Recipe recipe=null;
				for (Iterator<Recipe> iterator = plugin.getServer().recipeIterator(); iterator.hasNext();) {
					//ingredient map shape will return string array ingrefiantmap.get(char) can return itemstack ingredient check if everyone matches the array
					List<ItemStack> shapelessrl=new ArrayList<ItemStack>();
					recipe=iterator.next();
					
					if(recipe instanceof ShapedRecipe) {
						//System.out.println((recipe.getResult().getType().toString()));
						String[] recipeshape=((ShapedRecipe) recipe).getShape();
						char[][] Shape=new char[recipeshape.length][recipeshape[0].toCharArray().length];
						ItemStack[][] Stack=new ItemStack[recipeshape.length][recipeshape[0].toCharArray().length];
						/*for(int h=0;h<recipeshape.length;h++) {
							System.out.print(recipeshape[h]);
						}
						System.out.println("");
						System.out.println("==========");*/
						for(int j=0;j<recipeshape.length;j++) {
							for(int k=0;k<recipeshape[0].toCharArray().length;k++) {
								try {
									Shape[j][k]=recipeshape[j].toCharArray()[k];
								}catch(Exception ex) {
									Shape[j][k]=' ';
								}
							}
						}
						/*if(recipe.getResult().getType().equals(Material.WOOD_BUTTON)) {
							for(int h=0;h<9;h++) {
								System.out.print(Shape[h]);
							}
							System.out.println("");
						}*/
						for(int j=0;j<recipeshape.length;j++) {
							for(int k=0;k<recipeshape[0].toCharArray().length;k++) {
								if(((ShapedRecipe) recipe).getIngredientMap().get(Shape[j][k])==null||Shape[j][k]==' ') {
									Stack[j][k]=null;
								}else {
									Stack[j][k]=((ShapedRecipe) recipe).getIngredientMap().get(Shape[j][k]);
								}
							}
							
						}
						/*for(int i=0;i<9;i++) {
							System.out.print(Stack[i]);
						}
						System.out.println("");
						for(int i=0;i<9;i++) {
							System.out.print(myMatric[i]);
						}*/
						//generate the full map of all possible array[][], compare with each possible outcome, if succssfully find, then found otherwise not found
						ArrayList<ItemStack[][]> possibleShape=new ArrayList<ItemStack[][]>();
						int xpossible =3-recipeshape[0].toCharArray().length;
						int ypossible =3-recipeshape.length;
						int tpossible =(xpossible+1)*(ypossible+1);
						AutoBenchInfo1[] offset= new AutoBenchInfo1[tpossible];
						int tot=0;
							for(int x=0;x<=xpossible;x++) {
								for(int y=0;y<=ypossible;y++) {
									AutoBenchInfo1 ai=new AutoBenchInfo1(x,y);
									offset[tot]=ai;
									tot++;
								}
							}
						if(recipe.getResult().getType()==Material.TORCH)
						{for(int i=0;i<tpossible;i++) {
							System.out.println(offset[i].x+" "+offset[i].y);
						}}
							
						for(int t=0;t<tpossible;t++) {
							ItemStack[][] haha=new ItemStack[3][3];
							for(int x2=0;x2<3;x2++) {
								for(int y2=0;y2<3;y2++) {
									haha[x2][y2]=null;
								}
							}
															
							for(int x=0;x<recipeshape[0].toCharArray().length;x++) {
								for(int y=0;y<recipeshape.length;y++) {
									haha[offset[t].y+y][offset[t].x+x]=Stack[y][x];
								
								}
							}
							possibleShape.add(haha);
						}
						/*if(recipe.getResult().getType()==Material.TORCH) {
							System.out.println(xpossible+" "+ypossible+" "+tpossible);
							for(int h=0;h<possibleShape.size();h++) {
								for(int x=0;x<3;x++) {
									for(int y=0;y<3;y++) {
										if(possibleShape.get(h)[x][y]==null) {
											System.out.print("#");
										}else {
											System.out.print(possibleShape.get(h)[x][y].toString());
										}
									}
									System.out.println("^^^^^^^^^^^^");
								}
								System.out.println("");
								System.out.println("==========");
							}
							
							for(int x=0;x<3;x++) {
								for(int y=0;y<3;y++) {
									if(myMatric[x][y]==null) {
										System.out.print("#");
									}else {
										System.out.print(myMatric[x][y]);
									}
								}
								System.out.println("^^^^^^^^^^^^");
							}
							
						}*/
						boolean yoyo=false;
						for(int i=0;i<possibleShape.size();i++) {
							ItemStack[][] currentshape=possibleShape.get(i);
							boolean equal=true;
							//if(recipe.getResult().getType()==Material.TORCH) {System.out.println(i);}
							for(int x=0;x<3;x++) {
								for(int y=0;y<3;y++) {
									if(currentshape[x][y]!=null&&myMatric[x][y]!=null) {
										//if(recipe.getResult().getType()==Material.TORCH) {System.out.println("r1");}
										if(!currentshape[x][y].toString().equals((myMatric[x][y].toString()))) {
											//if(recipe.getResult().getType()==Material.TORCH) {System.out.println("r2");}
											equal=false;
										}
									}else if(currentshape[x][y]==null&&myMatric[x][y]==null) {
										//if(recipe.getResult().getType()==Material.TORCH) {System.out.println("r3");}
									}else {
										//if(recipe.getResult().getType()==Material.TORCH) {System.out.println("r4");}
										equal=false;
									}
								}
							}
							if(equal) {
								found=true;
								yoyo=true;
								break;
							}
						}
						if(yoyo) {
							break;
						}
						
					}else if(recipe instanceof ShapelessRecipe) {
						//System.out.println((recipe.getResult().getType().toString()));
						List<ItemStack> shapelessmatric=new ArrayList<ItemStack>();
						shapelessrl=((ShapelessRecipe) recipe).getIngredientList();
						for(int r=0;r<3;r++) {
							for(int r1=0;r1<3;r1++) {
								if(myMatric[r][r1]!=null) {
									shapelessmatric.add(myMatric[r][r1]);
								}
							}
						}
						/*if(recipe.getResult().getType()==Material.TRAPPED_CHEST) {
						for(ItemStack is:shapelessmatric) {
							System.out.println("matrix");
							System.out.println(shapelessmatric.size());
							System.out.println(is.getType());
						}
						System.out.println("");
						for(ItemStack is:shapelessrl) {
							System.out.println(shapelessrl.size());
							System.out.println(is.getType());
						}}*/
						
						for(int is=shapelessmatric.size()-1; is>=0 ; is--) {
							if(shapelessrl.contains(shapelessmatric.get(is))) {
								shapelessrl.remove(shapelessmatric.get(is));
								shapelessmatric.remove(shapelessmatric.get(is));
								
							}
						}
						boolean temp2=false;
							if(shapelessrl.isEmpty()&&shapelessmatric.isEmpty()) {
								temp2=true;
							}
						
						if(temp2) {
							found=true;
							//System.out.println("Invoke by shapeless");
							break;
						}
					}
					
				}
				if(found&&recipe!=null) {
					plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.result.item",recipe.getResult());
				}else {
					if(e.getWhoClicked() instanceof Player) {
						plugin.getServer().getPlayer(e.getWhoClicked().getName()).sendMessage(ChatColor.RED+"This Recipe is not available in this server auto workbench will not work, it will only act as a chest");;
					}
				}
				plugin.getcfmg().saveTable();
				e.getWhoClicked().closeInventory();
			}else if(e.getSlot()==26){
				popoutstuff(new Location(e.getWhoClicked().getLocation().getWorld(),Integer.parseInt(strarr[1]),Integer.parseInt(strarr[2]),Integer.parseInt(strarr[3])));
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.0.item","");
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.1.item","");
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.2.item","");
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.3.item","");
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.4.item","");
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.5.item","");
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.6.item","");
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.7.item","");
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.8.item","");
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.0.count",0);
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.1.count",0);
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.2.count",0);
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.3.count",0);
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.4.count",0);
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.5.count",0);
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.6.count",0);
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.7.count",0);
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.8.count",0);
				plugin.getcfmg().getTable().set("Table."+strarr[1]+","+strarr[2]+","+strarr[3]+".Recipe.result.item","");
				plugin.getcfmg().saveTable();
				e.getWhoClicked().closeInventory();
				generateAutoTable(Integer.parseInt(strarr[1]),Integer.parseInt(strarr[2]),Integer.parseInt(strarr[3]),plugin.getServer().getPlayer(e.getWhoClicked().getName()));
			}else {
				return;
			}
		}
		
		
	}
	public void popoutstuff(Location l) {
		for(int i=0;i<9;i++) {
			if(!plugin.getcfmg().getTable().getString("Table."+l.getBlockX()+","+l.getBlockY()+","+l.getBlockZ()+".Recipe."+i+".item").equals("")&&plugin.getcfmg().getTable().getInt("Table."+l.getBlockX()+","+l.getBlockY()+","+l.getBlockZ()+".Recipe."+i+".count")!=0) {
				ItemStack is=(ItemStack)plugin.getcfmg().getTable().get("Table."+l.getBlockX()+","+l.getBlockY()+","+l.getBlockZ()+".Recipe."+i+".item");
				is.setAmount(plugin.getcfmg().getTable().getInt("Table."+l.getBlockX()+","+l.getBlockY()+","+l.getBlockZ()+".Recipe."+i+".count"));
				l.getWorld().dropItem(l,is);
				plugin.getcfmg().getTable().set("Table."+l.getBlockX()+","+l.getBlockY()+","+l.getBlockZ()+".Recipe."+i+".count",0);
				plugin.getcfmg().saveTable();
		
			}	
		}
	}

}
