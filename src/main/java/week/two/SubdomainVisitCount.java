package week.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XiongShiyu
 * @description SubdomainVisitCount
 * @date 2022/4/24 22:03
 */
public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> timeMap = new HashMap(16);
        for(String domainAndTime : cpdomains) {
            String[] array = domainAndTime.split("\\s");
            Integer time = Integer.parseInt(array[0]);
            List<String> domains = domainSplit(array[1]);
            for(String domain : domains) {
                Integer oldTime = timeMap.getOrDefault(domain, 0);
                timeMap.put(domain, oldTime + time);
            }
        }
        List<String> retStr = new ArrayList();
        for(Map.Entry<String, Integer> entry : timeMap.entrySet()) {
            retStr.add(entry.getValue() + " " + entry.getKey());
        }
        return retStr;
    }

    private List<String> domainSplit(String domain) {
        String[] domainsPart = domain.split("\\.");
        List<String> domains = new ArrayList();
        jointDomain(domains, domainsPart, 0);
        return domains;
    }

    private String jointDomain(List<String> domains, String[] domainsPart, int start) {
        if(start == domainsPart.length - 1) {
            domains.add(domainsPart[start]);
            return domainsPart[start];
        }else{
            String subdomain = jointDomain(domains, domainsPart, ++start);
            String domain = domainsPart[--start] + "." + subdomain;
            domains.add(domain);
            return domain;
        }
    }
}
