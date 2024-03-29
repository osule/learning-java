import java .util.*;

public class LogTester {
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("data/short-test.log");
        la.printAll();
    }

    public void tesCountUniqueIPs() {
        LogAnalyzer la = new LogAnalyzer();

        la.readFile("data/weblog2_log.txt");
        int uniqueIPsCount = la.countUniqueIPs();
        System.out.println("Number of unique Ips: " + uniqueIPsCount);
    }

    public void testPrintAllHigherThanNum() {
        LogAnalyzer la = new LogAnalyzer();

        la.readFile("data/weblog1_log.txt");
        la.printAllHigherThanNum(400);
    }
    
    public void  testUniqueIPVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("data/weblog2_log.txt");
        ArrayList<String> uniqueIPVisits = la.uniqueIPVisitsOnDay("Sep 27");
        System.out.println("Unique IP Visits: " + uniqueIPVisits.size());
        
        for(String uniqueIP: uniqueIPVisits) {
            System.out.println(uniqueIP);
        }
    }
    
    public void testCountUniqueIPsInRange() {
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("data/weblog2_log.txt");
        int count = la.countUniqueIPsInRange(400, 499);
        System.out.println("UniqueIPs in range: " + count);
    }
    
    public void testCounts() {
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("data/short-test_log.txt");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        
        System.out.println(counts); 
    }
    
    public void testMostNumberVisitsByIP() {
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("data/weblog2_log.txt");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        
        System.out.println("Most number visits by IP: "+ la.mostNumberVisitsByIP(counts));
    }
    
    public void testIPsMostVisits() {
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("data/weblog2_log.txt");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        ArrayList<String> IPs = la.IPsMostVisits(counts);
        System.out.println(IPs);
    }
    
    public void testIPsForDays() {
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("data/weblog3-short_log.txt");
        HashMap<String, ArrayList<String>> daysIPs = la.IPsForDays();
        System.out.println("IPs for days: \n" +daysIPs);
    }
    
    public void testDayWithMostIPVisits() {
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("data/weblog2_log.txt");
        HashMap<String, ArrayList<String>> daysIPs = la.IPsForDays();
        String dayWithMostIPVisits = la.dayWithMostIPVisits(daysIPs);
        System.out.println("Day with most IP visits: " + dayWithMostIPVisits);
    }
    
    public void testIPsWithMostVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        
        la.readFile("data/weblog2_log.txt");
        HashMap<String, ArrayList<String>> daysIPs = la.IPsForDays();
        String day = "Sep 29";
        ArrayList<String> IPVisits = la.IPsWithMostVisitsOnDay(daysIPs, day);
        
        System.out.println("IPs with most visits on "+ day + " are: " + IPVisits);
    }
}