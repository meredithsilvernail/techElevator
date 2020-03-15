package com.techelevator;

import java.io.File;
import java.util.*;

public class Driver {

    public static final String FILE_PATH = "./PastTeamPairings.txt";

    public static final int TEAM_SIZE = 2;

    private static Map<String, Set<String>> participants;

    private static LinkedHashSet selectedNames;

    public static void main(String[] args){
        try{
            loadPartcipants();
        } catch (Exception e){
            System.exit(1);
        }
        //printParticipants();
        setTeams();
        printPairs();
    }

    public static void printParticipants(){
        System.out.println("****** PARTICIPANTS ******");
        for (String key : participants.keySet()){
            System.out.print("\n" + key + " : ");
            for (String partner : participants.get(key)){
                System.out.print(partner + ", ");
            }
        }
    }

    public static void setTeams() {
        while (true) {
            selectedNames = new LinkedHashSet<>(participants.size());
            Random random = new Random();
            List<String> names = new ArrayList<>(participants.keySet());
            while (names.size() - 1 >= 0) {
                String[] team = getNextTeam(random, names);
                for (String name : team) {
                    selectedNames.add(name);
                    names.remove(name);
                }
            }
            if  (isValidTeams()) {
                break;
            }
        }
    }

    public static String[] getNextTeam(Random random, List<String> names){
        String[] team = new String[TEAM_SIZE];

        for (int i=0; i < TEAM_SIZE; i++) {
            int index = random.nextInt(names.size());
            team[i] = names.get(index);
        }
        return team;
    }

    public static boolean isValidTeams(){
        Iterator it = selectedNames.iterator();
        while (it.hasNext()){
            Set<String> partners = participants.get((String)it.next());
            if (partners.contains((String) it.next())) {
                    return false;
            }
        }
        return true;
    }

    public static void printPairs(){
        System.out.println("****** NEW TEAMS ******");
        Iterator it = selectedNames.iterator();
        int index=0;
        int teamNumber = 1;
        while (it.hasNext()){
            if (index%TEAM_SIZE == 0){
                System.out.print("\nTeam " + teamNumber + " : " + it.next());
                teamNumber++;
            } else {
                System.out.print(", " + it.next());
            }
            index++;
        }
    }

    public static void loadPartcipants() throws Exception{
        participants = new HashMap<>();
        try( Scanner scanner = new Scanner(new File(FILE_PATH)) ){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (line.equals("---".trim())){
                    continue;
                }
                String[] team = line.split(",");
                if (team.length != TEAM_SIZE)
                    continue;
                for (int i=0; i < team.length; i++){
                    team[i] = team[i].trim();
                }
                addParticipant(team);
            }
        } catch (Exception e){
            System.out.println("Error loading file: " + e.getMessage());
            throw e;
        }
    }

    public static void addParticipant(String[] team){
        Set<String> keyNames = participants.keySet();
        for (String participant : team){
            if (!keyNames.contains(participant)){
                participants.put(participant, new HashSet<String>());
                //System.out.println("New Key: " + participant);
            }
            Set<String> partners = participants.get(participant);
            for (String partner : team){
                if ((!partner.equals(participant)) &&
                        (!partners.contains(partner))){
                  partners.add(partner);
                }
            }
        }
    }
}
