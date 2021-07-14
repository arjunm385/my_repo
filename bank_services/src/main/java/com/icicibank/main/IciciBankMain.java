package com.icicibank.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.icicibank.exceptions.BusinessException;
import com.icicibank.model.User;
import com.icicibank.model.UserAccount;
import com.icicibank.service.Emp_Details;
import com.icicibank.service.User_Details;


public class IciciBankMain {
	private static Logger log = Logger.getLogger(IciciBankMain.class);

	public static void main(String[] args) {
		Emp_Details empdetailsImpl = new com.icicibank.service.Impl.Emp_DetailsImpl();
		User_Details userdetailsImpl = new com.icicibank.service.Impl.User_DetailsImpl();
		
	
		Scanner sc = new Scanner(System.in);

		int ch = 0;

		do {
			log.info("Welcome to icici banking service app V1.0");
			log.info("===========================================");
			log.info("\nplease select the suitable option below");
			log.info("1)Login");
			log.info("2)Register");
			log.info("3)Exit");
			log.info("enter your choice between 1-3");
			log.info("\n===========================================");
			log.info("NOTE- please register if you are a new customer");
			log.info("#for any queries, feel free to contact @support.icici.com");
			try {
				ch = Integer.parseInt(sc.nextLine());

				switch (ch) {
				case 1:
					int s = 0;
					do {
						log.info("Hey there please choose from below");
						log.info("===========================================");

						log.info("\n1)Login as a customer");
						log.info("2)Login as an employee");
						log.info("3)Main menu");
						try {
							s = Integer.parseInt(sc.nextLine());

							switch (s) {
							case 1:
								int id;
								boolean c;
								do {
									c = true;

									log.info("please enter your registered userID");
									id = Integer.parseInt(sc.nextLine());
									int id1 = userdetailsImpl.checkUserid();
									if (id != id1) {
										System.out.println("user id not found....please retry");
										c = false;
									}
								} while (!c);
								

								
								 String password;
								 do {
										c = true;
										String pass1;
										log.info("please enter your password");
										 password = (sc.nextLine());
										pass1 = userdetailsImpl.checkUserPassword();
										if (!password.equals(pass1)) {
											System.out.println("incorrect....please retry");
											c = false;
										}
									} while (!c);

									log.info("login successfull");
									log.info("===========================================");

								break;
							case 2:
								
								do {
									c = true;

									log.info("please enter your registered userID");
									id = Integer.parseInt(sc.nextLine());
									int id1 = empdetailsImpl.checkEmpUid();
									if (id != id1) {
										System.out.println("user id not found....please retry");
										c = false;
									}
								} while (!c);

								do {
									c = true;
									String pass1;
									log.info("please enter your password");
									password = (sc.nextLine());

									pass1 = empdetailsImpl.checkEmpPassword();
									if (!password.equals(pass1)) {
										System.out.println("incorrect....please retry");
										c = false;
									}
								} while (!c);

								log.info("login successfull");
								log.info("===========================================");
								int s1 = 0;
								do {
									String name = empdetailsImpl.getEmpName();
									log.info("welcome :" + name + " to icici banking service portal");
									log.info("===========================================");
									log.info("\nplease select the suitable option below");
									log.info("1)all customer details");
									log.info("2)find customer details by filters");
									log.info("3)delete customer account");
									log.info("4)retuen to menu");
									log.info("enter your choice between 1-4");

									s1 = Integer.parseInt(sc.nextLine());
									try {
										switch (s1) {
										case 1:
											break;
										case 2:
											break;
										case 3:
											break;
										case 4:
											break;
										default:
											log.warn(
													"\nInvalid Choice... Please enter input between 1-4 or contact admin\n");
											break;
										}
									} catch (NumberFormatException e) {
										log.error("invalid entry **please choose a number only from above**\n");
									}
								} while (s1 != 4);
								break;
							case 3:
								break;
							default:
								log.warn("\nInvalid Choice... Please enter input between 1-3 or contact admin\n");
								break;
							}
						} catch (NumberFormatException e) {
							log.error("invalid entry **please choose a number only from above**\n");
						}

					} while (s != 3);
					break;

				case 2:

					log.info("welcome to icici family please enter the following details for registration");
					log.info("===========================================");
					log.info("please enter your name");
					String name = (sc.nextLine());

					log.info("please enter your phone number");
					String mobile = (sc.nextLine());

					
					String password;
					String pan;
					 String aadhar;
					 String city;
					 String state;
					 String pincode;
					 float balance;

					boolean c;
					do {
						log.info("please enter your password");
						password = (sc.nextLine());

						log.info("please confirm your password");
						String password1 = (sc.nextLine());
						c = true;
						if (!password.equals(password1)) {
							c = false;
							log.warn("password not matched...type again");
						}
					} while (!c);
                       int id=0;
					User user = new User(id, name, password, mobile);
				       
						user = userdetailsImpl.registerUser(user);
						if (user.getUserid() != 0) {
							log.info("account created with following details");
							log.info("name :" + name);
							log.info("user id :" + user.getUserid());
							log.info("phone no. :" + mobile);
							log.info("phone no. :" + mobile);
						}
						else
						log.error("choose different user id....user id already exist");
						
						log.info("===========================================");
						log.info("opening bank account");
						log.info("===========================================");
						do {c=true;
						log.info("please enter your pan number");
						pan=(sc.nextLine());
						if(!pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}"))
						{
							log.warn("invalid pan...try again");
							c=false;
						}
						}while(!c);
						
						do {c=true;
						log.info("please enter your aadhar number");
						aadhar=(sc.nextLine());
						if(!aadhar.matches("[0-9]{12}"))
						{
							log.warn("invalid aadhar...try again");
							c=false;
						}
						}while(!c);
						
						log.info("please enter your city");
						city=(sc.nextLine());

						log.info("please enter your state");
						state=(sc.nextLine());
						
						do {c=true;
						log.info("please enter your pincode");
						pincode=(sc.nextLine());
						if(!pincode.matches("[0-9]{6}"))
						{
							log.warn("invalid pincode...try again ");
							c=false;
						}
						}while(!c);
						
						do {c=true;
						log.info("please enter opening account balance");
						balance= Float.parseFloat(sc.nextLine());
						if(balance==0 || balance < 0)
						{
							log.warn("enter positive balance only... ");
							c=false;
						}
						}while(!c);
						
						long accno = 0;
						
						boolean status=false;
						 
						UserAccount userAccount= new UserAccount(user, accno, name, id, pan, aadhar, city, state, status, pincode, balance);
						userAccount=userdetailsImpl.registerUserAccount(userAccount);
						if (userAccount.getUserid() != 0) {
							log.info("account created with following details");
							log.info(userAccount);
						}
						else
						log.error("choose different user id....user id already exist");
						
						
						
					break;
				case 3:
					log.info("\nThanks for using our App.. See you soon. :)");
					break;
				default:
					log.warn("\nInvalid Choice... Please enter input between 1-3 or contact admin\n");
					break;

				}
			} catch (NumberFormatException | BusinessException e) {
				System.out.println("invalid entry **please choose a number only from above**\n");
			}
		} while (ch != 3);
	}

}
