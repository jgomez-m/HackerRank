package codility.userstats;

import java.util.*;
import java.util.stream.*;

class VisitCounter {

    class UserStats {
        private Optional<Long> visitCount;

        public UserStats(Optional<Long> visitCount) {
            this.visitCount = visitCount;
        }

        public Optional<Long> getVisitCount() {
            return visitCount;
        }
    }

    Map<Long, Long> count(Map<String, UserStats>... visits) {
        if (visits == null || visits.length == 0){
            return Collections.emptyMap();
        }

        return Arrays.stream(visits)
                .filter(Objects::nonNull)
                .flatMap(map -> map.entrySet().stream())
                .map(entry -> {
                    try {
                        Long userId = Long.parseLong(entry.getKey());
                        return entry.getValue() != null && entry.getValue().getVisitCount().isPresent() ?
                                new AbstractMap.SimpleEntry<>(userId, entry.getValue().getVisitCount().get()) : null;
                    } catch (NumberFormatException ex) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingLong(Map.Entry::getValue)
                ));
    }
}
