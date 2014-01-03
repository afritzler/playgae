package managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Contestant;
import models.Vote;

public class ResultManager {

	public List<ResultRow> calculateResults() {
		List<ResultRow> results = new ArrayList<ResultRow>();
		Map<Long, Integer> countMap = new HashMap<Long, Integer>();
		// get all votes
		List<Vote> votes = Vote.all().fetch();
		
		// loop over votes and count 
		if (votes != null) {
			for (Vote vote : votes) {
				if (Contestant.findById(vote.choice) != null) { // check if the contestant exists
					if (countMap.containsKey(vote.choice)) {
						int newCount = countMap.get(vote.choice) + 1; // increment existing one
						countMap.put(vote.choice, newCount); 
					} else {
						countMap.put(vote.choice, 1); // new one
					}
				}
			}
		}
		
		// merge results
		for (Long id : countMap.keySet()) {
			Contestant contestant = Contestant.findById(id);
			ResultRow rw = new ResultRow();
			rw.name = contestant.name;
			rw.count = countMap.get(id);
			results.add(rw);
		}
		
		// sort result
		Collections.sort(results, new Comparator<ResultRow>() {
			@Override
			public int compare(ResultRow o1, ResultRow o2) {
				return o1.count > o2.count ? -1 : o1.count == o2.count ? 1 : 0;
			}
		});
		
		return results;
	}
	
	public class ResultRow {
		public String name;
		public int count;
	}
	
}
