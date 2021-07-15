package com.icicibank.main;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.icicibank.exceptions.BusinessException;
import com.icicibank.model.User;
import com.icicibank.model.UserAccount;
import com.icicibank.model.UserTransaction;
import com.icicibank.service.Emp_Details;
import com.icicibank.service.User_Details;


public class IciciBankMain {
	private static Logger log = Logger.getLogger(IciciBankMain.class);

	public static void main(String[] args) {
		Emp_Details empdetailsImpl = new com.icicibank.service.Impl.Emp_DetailsImpl();
		User_Details userdetailsImpl = new com.icicibank.service.Impl.User_DetailsImpl();

		Scanner sc = new Scanner(System.in);
		boolean c=true;

		int ch = 0;

		do {
			log.info("Welcome to ICICI Sanking Service App v1.0");
			log.info("===========================================");
			log.info("\nPlease select suitable option from below");
			log.info("1)Login");
			log.info("2)Register");
			log.info("3)Exit");
			log.info("Enter your choice between 1-3");
			log.info("\n===========================================");
			log.info("NOTE- Please register if you are a new customer");
			log.info("#For any queries, feel free to contact @support.icici.com");
			try {
				ch = Integer.parseInt(sc.nextLine());

				switch (ch) {
				case 1:
					int s = 0;
					do {
						log.info("Hey there! Please choose from below options-");
						log.info("===========================================");

						log.info("\n1)Login as a customer");
						log.info("2)Login as an employee");
						log.info("3)Return to Main Menu");
						try {
							s = Integer.parseInt(sc.nextLine());

							switch (s) {
							case 1:
								
								int d = 0;
								do {
									c=true;
									log.info("Please enter your registered userID");
									int id = Integer.parseInt(sc.nextLine());
									boolean z = userdetailsImpl.checkUserid(id);
									
									if(z==true)
									{
										System.out.println("User Id found");
										d=id;
									}
									else {
										System.out.println("Incorrect User Id... Enter Again");
										c=false;
									}
								}while(!c);

								
								do {
									c = true;
									log.info("Enter your password");
									String password = (sc.nextLine());
									boolean z = userdetailsImpl.checkUserPassword(password,d);
									if(z==true)
									{
										System.out.println("Password is correct");
									}
									else {
										System.out.println("Incorrect Password... Enter Again");
										c=false;
									}
								} while (!c);

								log.info("Login Successful !");
								log.info("===========================================");
								int s2;
								do {
								log.info("Welcome to ICICI Banking Services");
								log.info("Kindly choose from below options-");
								log.info("1. Check Balance");
								log.info("2. Cash Deposit");
								log.info("3. Cash Withdrawl");
								log.info("4. get mini statement");
								log.info("5. check account number");
								log.info("6. Go to Previous Menu");
//								log.info("4. Transfer Money");
								
								s2 = Integer.parseInt(sc.nextLine());
								long acc=userdetailsImpl.getAccountNumber(d);
								try {
									switch (s2) {
									case 1:
										float bal=userdetailsImpl.checkBalance(acc);
										log.info("current account balance is :"+bal);
										break;
									case 2:
										
										float amt;
										do {
											c = true;
											log.info("enter amount you want to deposit :");
											
											amt = Float.parseFloat(sc.nextLine());
											if (amt == 0 || amt < 0) {
												log.warn("Enter positive Balance only... ");
												c = false;
											}
										} while (!c);
										
										float pamt=userdetailsImpl.checkBalance(acc);
										userdetailsImpl.addBal(amt, pamt, acc);
										log.info("updated account balance is :"+userdetailsImpl.checkBalance(acc));
										
										break;
									case 3:
										pamt=userdetailsImpl.checkBalance(acc);
										do {
											c = true;
											log.info("enter amount you want to withdrawl :");
											
											amt = Float.parseFloat(sc.nextLine());
											if (amt > pamt) {
												log.warn("not enough balance... ");
												c = false;
											}
										} while (!c);
										userdetailsImpl.withdrawBal(amt, pamt, acc);
										log.info("updated account balance is :"+userdetailsImpl.checkBalance(acc));
										
										break;
									case 4:
										long transactionid = 0;
										String transactiontype = null;
										float tamt = 0;
										UserTransaction userTransaction= new UserTransaction(acc, tamt, transactionid, transactiontype);
                                        userdetailsImpl.getTxnDetails(acc , userTransaction);					
										break;
										
									case 5:
										log.info("your account no. is: "+acc);
										break;
									case 6:
										break;
										
									default:
										log.warn(
												"\nInvalid Choice !! ... Please enter input between 1-4 or contact admin\n");
										break;
									}
								} catch (NumberFormatException e) {
									log.error("Invalid Entry ! **Please choose an option from above only**\n");
								}
								
								}while(s2!=6);
							
								
								break;
							case 2:
								
								String password=null;
								int id;

								do {
									c = true;

									log.info("Please enter your registered userId");
									id = Integer.parseInt(sc.nextLine());
									int id1 = empdetailsImpl.checkEmpUid();
									if (id != id1) {
										System.out.println("User Id not found.... Please Retry");
										c = false;
									}
								} while (!c);

								do {
									c = true;
									String pass1;
									log.info("Enter your Password");
									password = (sc.nextLine());

									pass1 = empdetailsImpl.checkEmpPassword();
									if (!password.equals(pass1)) {
										System.out.println("Incorrect !! .... Please Try again!");
										c = false;
									}
								} while (!c);

								log.info("Login Successful");
								log.info("===========================================");
								int s1 = 0;
								do {
									String name = empdetailsImpl.getEmpName();
									log.info("Welcome :" + name + " to ICICI Banking Service App");
									log.info("===========================================");
									log.info("\nPlease select the suitable option from below-");
									log.info("1)All customer details");
									log.info("2)Find customer details by filters");
									log.info("3)Delete customer account");
									log.info("4)Return to menu");
									log.info("Enter your choice between 1-4");

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
													"\nInvalid Choice !! ... Please enter input between 1-4 or contact admin\n");
											break;
										}
									} catch (NumberFormatException e) {
										log.error("Invalid Entry ! **Please choose an option from above only**\n");
									}
								} while (s1 != 4);
								break;
							case 3:
								break;
							default:
								log.warn("\nInvalid Choice X ... Enter input between 1-3 or contact admin\n");
								break;
							}
						} catch (NumberFormatException e) {
							log.error("Invalid Entry X **Please choose an option from above**\n");
						}

					} while (s != 3);
					break;

				case 2:

					log.info("Welcome to ICICI Family. Please enter the following details for getting registered !");
					log.info("===========================================");
					log.info("Please enter your Full Name");
					String name = (sc.nextLine());

					log.info("Enter your Phone Number");
					String mobile = (sc.nextLine());

					String password;
					String pan;
					String aadhar;
					String city;
					String state;
					String pincode;
					float balance;

					
					do {
						log.info("Enter your Password");
						password = (sc.nextLine());

						log.info("Confirm Password");
						String password1 = (sc.nextLine());
						c = true;
						if (!password.equals(password1)) {
							c = false;
							log.warn("X Password not matched! ... Type again");
						}
					} while (!c);

					log.info("===========================================");
					log.info("Opening new Bank Account");
					log.info("===========================================");
					do {
						c = true;
						log.info("Kindly enter your PAN number");
						pan = (sc.nextLine());
						if (!pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
							log.warn("Invalid PAN ! ... Try Again");
							c = false;
						}
					} while (!c);

					do {
						c = true;
						log.info("Please enter your 12-digit Aadhar Number");
						aadhar = (sc.nextLine());
						if (!aadhar.matches("[0-9]{12}")) {
							log.warn("Invalid aadhar !! ... Type Again");
							c = false;
						}
					} while (!c);

					log.info("Enter your City name");
					city = (sc.nextLine());

					log.info("Enter your state");
					state = (sc.nextLine());

					do {
						c = true;
						log.info("Enter your Pincode");
						pincode = (sc.nextLine());
						if (!pincode.matches("[0-9]{6}")) {
							log.warn("Invalid Pincode! ... Type Again ");
							c = false;
						}
					} while (!c);

					do {
						c = true;
						log.info("Enter opening account Balance deposit ");
						
						balance = Float.parseFloat(sc.nextLine());
						if (balance == 0 || balance < 0) {
							log.warn("Enter positive Balance only... ");
							c = false;
						}
					} while (!c);

					int id = 0;
					User user = new User(id, name, password, mobile);
					user = userdetailsImpl.registerUser(user);
					log.info("Account created with following details - ");
					log.info("Name :" + name);
					log.info("User id :" + user.getUserid());
					log.info("Password :" + password);
					log.info("Phone No. :" + mobile);
					boolean status = false;
					name = user.getCustname();
					long accno = 0;
					UserAccount userAccount = new UserAccount(user, accno, name, user.getUserid(), pan, aadhar, city,
							state, status, pincode, balance);
					
					String open="opening deposited balance";
					userAccount = userdetailsImpl.registerUserAccount(userAccount);
					userdetailsImpl.txnAdd(open, userAccount.getAccount(), balance);

					log.info("Account created with following details - ");
					log.info(userAccount);

					break;
				case 3:
					log.info("\nThanks for using our App.. See you soon! :)");
					break;
				default:
					log.warn("\nInvalid Choice... Please enter input between 1-3 or contact admin\n");
					break;

				}
			} catch (NumberFormatException | BusinessException e) {
				System.out.println("Invalid Entry! X ! **Please choose an option from above only **\n");
			}
		} while (ch != 3);
	}

}
