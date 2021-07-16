package com.icicibank.main;

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
		boolean c = true;

		int ch = 0;

		do {
			log.info("Welcome to ICICI Banking Service App v1.0");
			log.info("===========================================");
			log.info("\nPlease select suitable option from below");
			log.info("1) Login");
			log.info("2) Register");
			log.info("3) Exit");
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
						log.info("Hello there! Please choose from below options-");
						log.info("===========================================");

						log.info("\n1) Login as a customer");
						log.info("2) Login as an employee");
						log.info("3) Return to Main Menu");
						try {
							s = Integer.parseInt(sc.nextLine());

							switch (s) {
							case 1:

								int d = 0;
								do {
									c = true;
									log.info("Please enter your registered userID");
									int id = Integer.parseInt(sc.nextLine());
									boolean z = userdetailsImpl.checkUserid(id);

									if (z == true) {
										System.out.println("User Id found");
										d = id;
									} else {
										System.out.println("Incorrect User Id... Enter Again");
										c = false;
									}
								} while (!c);

								do {
									c = true;
									log.info("Enter your password");
									String password = (sc.nextLine());
									boolean z = userdetailsImpl.checkUserPassword(password, d);
									if (z == true) {
										System.out.println("Password is correct");
									} else {
										System.out.println("Incorrect Password... Enter Again");
										c = false;
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
									log.info("4. Get mini statement");
									log.info("5. Check account number");
									log.info("6. Transfer Money");
									log.info("7. Go to Previous Menu");

									s2 = Integer.parseInt(sc.nextLine());
									long acc = userdetailsImpl.getAccountNumber(d);
									try {
										switch (s2) {
										case 1:
											float bal = userdetailsImpl.checkBalance(acc);
											log.info("Current Account Balance is :" + bal);
											break;
										case 2:

											float amt;
											do {
												c = true;
												log.info("Enter amount you want to deposit :");

												amt = Float.parseFloat(sc.nextLine());
												if (amt == 0 || amt < 0) {
													log.warn("Enter positive Balance only... ");
													c = false;
												}
											} while (!c);

											float pamt = userdetailsImpl.checkBalance(acc);
											userdetailsImpl.addBal(amt, pamt, acc);
											log.info(
													"Updated Account Balance is :" + userdetailsImpl.checkBalance(acc));

											break;
										case 3:
											pamt = userdetailsImpl.checkBalance(acc);
											do {
												c = true;
												log.info("Enter amount you want to withdraw :");

												amt = Float.parseFloat(sc.nextLine());
												if (amt > pamt) {
													log.warn("NOT enough balance... ");
													c = false;
												}
											} while (!c);
											userdetailsImpl.withdrawBal(amt, pamt, acc);
											log.info(
													"Updated Account Balance is :" + userdetailsImpl.checkBalance(acc));

											break;
										case 4:
											long transactionid = 0;
											String transactiontype = null;
											float tamt = 0;
											UserTransaction userTransaction = new UserTransaction(acc, tamt,
													transactionid, transactiontype);
											userdetailsImpl.getTxnDetails(acc, userTransaction);
											break;

										case 5:
											log.info("Your Account no. is: " + acc);
											break;
										case 6:
											long tr_acc = 0;
											do {
												c = true;
												log.info("Enter Account Number of Other User");
												tr_acc = Long.parseLong(sc.nextLine());
												boolean z = false;
												if (tr_acc == acc)
													log.info("Please enter other person's account number...NOT Yours");

												else
													z = empdetailsImpl.checkUserAccount(tr_acc);

												if (z == true) {
													log.info("Account Record Found");
													log.info("name: " + userdetailsImpl.getUserNameByAccount(tr_acc));

												} else {
													System.out.println("Incorrect Account Number! Enter Again");
													c = false;
												}

											} while (!c);

											log.info("Enter Amount you Want to Transfer: ");
											float tr_amt = Float.parseFloat(sc.nextLine());
											if (tr_amt > userdetailsImpl.checkBalance(acc)) {
												log.info("NOT enough balance...Go and deposit some money :(");
											} else {
												userdetailsImpl.moneyTransfer(tr_amt, acc, tr_acc);
												log.info("Money Transfer to account: "+tr_acc+" is Successful");
												log.info("Your Updated Balance is: "+userdetailsImpl.checkBalance(acc));
											}

											break;

										case 7:
											break;

										default:
											log.warn(
													"\nInvalid Choice !! ... Please enter input between 1-4 or contact admin\n");
											break;
										}
									} catch (NumberFormatException e) {
										log.error("Invalid Entry ! **Please choose an option from above only**\n");
									}

								} while (s2 != 7);

								break;
							case 2:

								String password = null;
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
									log.info("Enter Password");
									password = (sc.nextLine());

									pass1 = empdetailsImpl.checkEmpPassword();
									if (!password.equals(pass1)) {
										System.out.println("Incorrect !! .... Please Try again!");
										c = false;
									}
								} while (!c);

								log.info("Login Successful!");
								log.info("===========================================");
								int s1 = 0;
								do {
									String name = empdetailsImpl.getEmpName();
									log.info("Welcome :" + name + " to ICICI Banking Service App");
									log.info("===========================================");
									log.info("\nPlease select the suitable option from below-");
									log.info("1) Details of all customers");
									log.info("2) Find customer details by Account Number");
									log.info("3) Find customer details by User Id");
									log.info("4) View transaction history of particular account");
									log.info("5) All Transaction logs");
									log.info("6) Delete customer account");
									log.info("7) Return to menu");
									log.info("Enter your choice between 1-7");

									s1 = Integer.parseInt(sc.nextLine());
									try {
										switch (s1) {
										case 1:
											empdetailsImpl.getAllUserDetails();
											break;
										case 2:

											long accn = 0;
											do {
												c = true;
												log.info("Enter Account Number");
												accn = Long.parseLong(sc.nextLine());

												boolean z = empdetailsImpl.checkUserAccount(accn);

												if (z == true) {
													System.out.println("Account Record Found");
												} else {
													System.out.println("Incorrect Account Number! Enter Again");
													c = false;
												}
											} while (!c);

											UserAccount userAccount = empdetailsImpl.getAllUserDetailsByAccount(accn);
											log.info(userAccount);

											break;
										case 3:
											int uid = 0;
											do {
												c = true;
												log.info("Please enter your registered userID");
												int u_id = Integer.parseInt(sc.nextLine());
												boolean z = userdetailsImpl.checkUserid(u_id);

												if (z == true) {
													System.out.println("User Id found :)");
													uid = u_id;
												} else {
													System.out.println("Incorrect User Id... Enter Again");
													c = false;
												}
											} while (!c);
											userAccount = empdetailsImpl.getAllUserDetailsById(uid);
											log.info(userAccount);

											break;
										case 4:
											do {
												c = true;
												log.info("Enter Account Number");
												accn = Long.parseLong(sc.nextLine());

												boolean z = empdetailsImpl.checkUserAccount(accn);

												if (z == true) {
													System.out.println("Account Record Found");
												} else {
													System.out.println("Incorrect Account Number! Enter Again");
													c = false;
												}
											} while (!c);
											empdetailsImpl.getTransactionsByaccount(accn);
											break;
										case 5:
											empdetailsImpl.getAllTransactions();
											break;
										case 6:
											do {
												c = true;
												log.info("Enter Account Number");
												accn = Long.parseLong(sc.nextLine());

												boolean z = empdetailsImpl.checkUserAccount(accn);

												if (z == true) {
													System.out.println("Account Record Found");
												} else {
													System.out.println("Incorrect Account Number... Enter Again");
													c = false;
												}
											} while (!c);

											empdetailsImpl.deleteCustomerAccount(accn);
											log.info("Customer Account Deleted... :(");

											break;
										case 7:

											break;
										default:
											log.warn(
													"\nInvalid Choice !! ... Please enter input between 1-4 or contact admin\n");
											break;
										}
									} catch (NumberFormatException e) {
										log.error("Invalid Entry ! **Please choose an option from above only**\n");
									}
								} while (s1 != 7);
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
						log.info("Enter opening deposit amount");

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
					UserAccount userAccount = new UserAccount(accno, name, user.getUserid(), pan, aadhar, city, state,
							status, pincode, balance);

					String open = "opening deposited balance";
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
