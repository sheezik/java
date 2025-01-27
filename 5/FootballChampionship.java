/*
Во входном файле находятся результаты чемпионата России по футболу в виде списка матчей. Каждый матч обозначен
в отдельной строке: название первой команды, название второй команды, счёт матча в виде двух целых чисел.
Каждая команда сыграла с каждой ровно один раз. Построить и вывести в выходной файл итоговую таблицу чемпионата:
в строках - команды; в столбцах итоги – количество побед, ничьих, поражений, забитых и пропущенных мячей,
количество очков, занятое место. За каждую победу команде начисляется 3 очка, за ничью - 1 очко, за поражение 0 очков.
Таблица должна быть упорядочена по убыванию набранных очков. Если несколько команд набрали одинаковое число очков,
то учитываются следующие критерии: лучшая разность забитых и пропущенных мячей, количество побед, личная встреча.
Кондаков А.А ПИ-2Э 03.05.24
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class FootballChampionship {

    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        // Читаем результаты матчей из входного файла
        Map<String, Team> teams = readMatches(inputFileName);

        // Упорядочиваем команды по набранным очкам, разности забитых и пропущенных мячей, количеству побед и личным встречам
        List<Team> sortedTeams = sortTeams(teams);

        // Формируем итоговую таблицу чемпионата
        String table = formatTable(sortedTeams);

        // Записываем итоговую таблицу в выходной файл
        writeTableToFile(outputFileName, table);

        System.out.println("Итоговая таблица чемпионата записана в файл " + outputFileName);
    }

    private static Map<String, Team> readMatches(String inputFileName) {
        Map<String, Team> teams = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(inputFileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                String team1Name = parts[0];
                String team2Name = parts[1];
                int team1Goals = Integer.parseInt(parts[2]);
                int team2Goals = Integer.parseInt(parts[3]);

                Team team1 = teams.getOrDefault(team1Name, new Team(team1Name));
                Team team2 = teams.getOrDefault(team2Name, new Team(team2Name));

                team1.addMatch(team2, team1Goals, team2Goals);
                team2.addMatch(team1, team2Goals, team1Goals);

                teams.put(team1Name, team1);
                teams.put(team2Name, team2);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл " + inputFileName + " не найден");
        }

        return teams;
    }

    private static List<Team> sortTeams(Map<String, Team> teams) {
        List<Team> sortedTeams = new ArrayList<>(teams.values());
        sortedTeams.sort(Comparator.comparing(Team::getPoints).reversed()
                .thenComparing(Team::getGoalDifference).reversed()
                .thenComparing(Team::getWins).reversed()
                .thenComparing(team -> team.getHeadToHead(sortedTeams.get(0))));

        return sortedTeams;
    }

    private static String formatTable(List<Team> teams) {
        StringBuilder sb = new StringBuilder();

        sb.append("Итоговая таблица чемпионата:\n");
        sb.append(String.format("%-20s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "Команда", "П", "Н", "П", "З", "П", "О", "Место"));

        int rank = 1;
        for (Team team : teams) {
            sb.append(String.format("%-20s %-10d %-10d %-10d %-10d %-10d %-10d %-10d\n",
                    team.getName(),
                    team.getWins(),
                    team.getDraws(),
                    team.getLosses(),
                    team.getGoalsScored(),
                    team.getGoalsConceded(),
                    team.getPoints(),
                    rank++));
        }

        return sb.toString();
    }

    private static void writeTableToFile(String outputFileName, String table) {
        try (PrintWriter writer = new PrintWriter(new File(outputFileName))) {
            writer.println(table);
        } catch (FileNotFoundException e) {
            System.err.println("Файл " + outputFileName + " не может быть создан");
        }
    }

    private static class Team {

        private String name;
        private int wins;
        private int draws;
        private int losses;
        private int goalsScored;
        private int goalsConceded;
        private int points;
        private Map<Team, Integer[]> headToHead;

        public Team(String name) {
            this.name = name;
            this.wins = 0;
            this.draws = 0;
            this.losses = 0;
            this.goalsScored = 0;
            this.goalsConceded = 0;
            this.points = 0;
            this.headToHead = new HashMap<>();
        }

        public String getName() {
            return name;
        }

        public int getWins() {
            return wins;
        }

        public int getDraws() {
            return draws;
        }

        public int getLosses() {
            return losses;
        }

        public int getGoalsScored() {
            return goalsScored;
        }

        public int getGoalsConceded() {
            return goalsConceded;
        }

        public int getPoints() {
            return points;
        }

        public int getGoalDifference() {
            return goalsScored - goalsConceded;
        }

        public void addMatch(Team opponent, int myGoals, int opponentGoals) {
            if (myGoals > opponentGoals) {
                wins++;
                points += 3;
            } else if (myGoals == opponentGoals) {
                draws++;
                points++;
            } else {
                losses++;
            }

            goalsScored += myGoals;
            goalsConceded += opponentGoals;

            // Добавляем результат в headToHead только если матч не был записан
            if (!headToHead.containsKey(opponent)) {
                headToHead.put(opponent, new Integer[]{myGoals, opponentGoals});
            }
        }

        public int getHeadToHead(Team opponent) {
            Integer[] result = headToHead.get(opponent);
            return result[0] - result[1];
        }
    }
}