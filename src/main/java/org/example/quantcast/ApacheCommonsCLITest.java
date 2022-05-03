package org.example.quantcast;

import org.apache.commons.cli.*;

/* Add Maven dependency for Apache Commons CLI */
public class ApacheCommonsCLITest {
    public static void main(String[] args) throws Exception {
        Options optionsGroup = new Options();

        Option dateOption = Option.builder("d").longOpt("date")
                .argName("date")
                .hasArg()
                .required(true)
                .desc("Enter Date").build();
        optionsGroup.addOption(dateOption);

        Option name = new Option("f", "name", true, "First Name");
        name.setRequired(true);
        optionsGroup.addOption(name);

        Option mobileNumber = new Option("m", "mobilenumber", true, "Mobile Number");
        mobileNumber.setRequired(false);
        optionsGroup.addOption(mobileNumber);

        HelpFormatter formatter = new HelpFormatter();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(optionsGroup, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("User Profile Info", optionsGroup);
            System.exit(1);
            return;
        }
        System.out.println("User First Name is: " + cmd.getOptionValue("name"));
        if (cmd.hasOption("m")) {
            System.out.println("User Mobile Number is: " + cmd.getOptionValue("mobilenumber"));
        }
    }
}
