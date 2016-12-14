package com.epam.javacourses2016.task17;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * На плоскости задано N отрезков.
 * Найти точку (возможно несколько) пересечения двух отрезков, имеющую минимальную абсциссу.
 * Использовать класс TreeMap.
 */
public class SolverTask17 {

    private TreeMap<Point2D, EventPoint> eventPointTreeMap;
    private TreeMap<Segment, Point2D> segmentTreeMap;
    /**
     * Осуществляет анализ переданных отрезков.
     *
     * @param segments Множество отрезков.
     * @return Множество точек пересечения, имеющих минимальную абсциссу.
     */
    public Set<Point2D> analyze(Set<Segment> segments) {
        Set<Point2D> result = new HashSet<>();
        eventPointTreeMap = new TreeMap<>(new Comparator<Point2D>() {
            @Override
            public int compare(Point2D o1, Point2D o2) {
                if(o1.getY() > o2.getY())
                    return 1;
                else if(o1.getY() < o2.getY())
                    return -1;
                else {
                    if(o1.getX() < o2.getX())
                        return 1;
                    if(o1.getX() > o2.getX())
                        return -1;
                    else return 0;
                }
            }
        });//Статус всех событий на карте
        segmentTreeMap = new TreeMap<>(new Comparator<Segment>() {
            @Override
            public int compare(Segment o1, Segment o2) {
                if(o1.getA().getX() == o2.getA().getX()
                        && o1.getA().getY() == o2.getA().getY()
                        && o1.getB().getX() == o2.getB().getX()
                        && o1.getB().getY() == o2.getB().getY())
                    return 0;
                return 1;
            }
        });//Статус пересекающей прямой
        for(Segment s : segments) {
            if(comparePoints(s.getA(),s.getB()) == 1) {
                if(eventPointTreeMap.containsKey(s.getA())) {
                    eventPointTreeMap.get(s.getA()).setEventType(Event.INTERSECTION);
                    eventPointTreeMap.get(s.getA()).addSegment(s);
                } else {
                    EventPoint eventPointA = new EventPoint(Event.TOPPOINT);
                    eventPointA.addSegment(s);
                    eventPointTreeMap.put(s.getA(),eventPointA);
                }
                if(eventPointTreeMap.containsKey(s.getB())) {
                    eventPointTreeMap.get(s.getB()).setEventType(Event.INTERSECTION);
                    eventPointTreeMap.get(s.getB()).addSegment(s);
                } else {
                    EventPoint eventPointB = new EventPoint(Event.LOWESTPOINT);
                    eventPointB.addSegment(s);
                    eventPointTreeMap.put(s.getB(),eventPointB);
                }
            } else {
                if(eventPointTreeMap.containsKey(s.getA())) {
                    eventPointTreeMap.get(s.getA()).setEventType(Event.INTERSECTION);
                    eventPointTreeMap.get(s.getA()).addSegment(s);
                } else {
                    EventPoint eventPoint = new EventPoint(Event.LOWESTPOINT);
                    eventPoint.addSegment(s);
                    eventPointTreeMap.put(s.getA(),eventPoint);
                }
                if(eventPointTreeMap.containsKey(s.getB())) {
                    eventPointTreeMap.get(s.getB()).setEventType(Event.INTERSECTION);
                    eventPointTreeMap.get(s.getB()).addSegment(s);
                } else {
                    EventPoint eventPoint = new EventPoint(Event.TOPPOINT);
                    eventPoint.addSegment(s);
                    eventPointTreeMap.put(s.getB(),eventPoint);
                }
            }
        }
        LinkedList<Map.Entry<Point2D, EventPoint>> list = new LinkedList<>(eventPointTreeMap.entrySet());
        Iterator<Map.Entry<Point2D, EventPoint>> it = list.descendingIterator();
        while(it.hasNext()) {
            Map.Entry<Point2D, EventPoint> point2DSetEntry = it.next();
            handlePoint(point2DSetEntry, result);
        }
        return result;
    }

    private int comparePoints(Point2D a, Point2D b) {
        if(a.getY() > b.getY())
            return 1;
        else if(a.getY() < b.getY())
            return -1;
        else {
            if(a.getX() < b.getX())
                return 1;
            else if(a.getX() > b.getX())
                return -1;
            else return 0;
        }
    }

    private void handlePoint(Map.Entry<Point2D, EventPoint> eventPoint, Set<Point2D> result) {
        Event event = eventPoint.getValue().getEventType();
        switch (event) {
            case TOPPOINT: {
                Iterator<Segment> it = eventPoint.getValue().getEventSegments().iterator();
                Segment segment = it.next();
                for (Map.Entry<Segment,Point2D> s : segmentTreeMap.entrySet()) {
                    Point2D newPoint = findIntersection(s.getKey().getA(), s.getKey().getB(), segment.getA(), segment.getB());
                    if (newPoint != null) {
                        EventPoint eventPoint1 = new EventPoint(Event.INTERSECTION);
                        eventPoint1.addSegment(segment);
                        eventPoint1.addSegment(s.getKey());
                        eventPointTreeMap.put(newPoint, eventPoint1);
                    }
                }
                segmentTreeMap.put(segment, eventPoint.getKey());
                break;
            }
            case LOWESTPOINT: {
                eventPointTreeMap.remove(eventPoint.getKey());
                segmentTreeMap.values().remove(eventPoint.getKey());
                break;
            }
            case INTERSECTION: {
                Iterator<Segment> it = eventPoint.getValue().getEventSegments().iterator();
                while(it.hasNext()) {
                    Segment segment = it.next();
                    segmentTreeMap.put(segment,eventPoint.getKey());
                }
                Set<Segment> segments = segmentTreeMap.keySet();
                Segment[] segarray = segments.toArray(new Segment[segments.size()]);
                for(int i = 0; i < segarray.length-1; i++) {
                    for(int j = i+1; j < segarray.length; j++) {
                        Point2D newPoint = findIntersection(segarray[i].getA(), segarray[i].getB(), segarray[j].getA(), segarray[j].getB());
                        if (newPoint != null) {
                            if(eventPointTreeMap.containsKey(newPoint)) {
                                eventPointTreeMap.get(newPoint).getEventSegments().add(segarray[i]);
                                eventPointTreeMap.get(newPoint).getEventSegments().add(segarray[j]);
                            } else {
                                EventPoint eventPoint1 = new EventPoint(Event.INTERSECTION);
                                eventPoint1.addSegment(segarray[i]);
                                eventPoint1.addSegment(segarray[j]);
                                eventPointTreeMap.put(newPoint, eventPoint1);
                            }
                        }
                    }
                }
                result.add(eventPoint.getKey());
            }
            default:
                break;
        }
    }

    private Point2D findIntersection(Point2D p1, Point2D p2, Point2D p3, Point2D p4) {
        Point2D result = new Point2D();
        double k1 = (p2.getX() - p1.getX()) / (p2.getY() - p1.getY());
        double k2 = (p4.getX() - p3.getX()) / (p4.getY() - p3.getY());
        if(k1 != k2) {
            result.setX(((p1.getX() * p2.getY() - p2.getX() * p1.getY()) * (p4.getX() - p3.getX()) -
                    (p3.getX() * p4.getY() - p4.getX() * p3.getY()) * (p2.getX() - p1.getX())) / ((p1.getY() - p2.getY()) * (p4.getX() - p3.getX()) - (p3.getY() - p4.getY()) * (p2.getX() - p1.getX())));
            result.setY(((p3.getY() - p4.getY()) * result.getX() - (p3.getX() * p4.getY() - p4.getX() * p3.getY())) / (p4.getX() - p3.getX()));
        }
        if((((p1.getX() <= result.getX()) && (p2.getX() >= result.getX()) && (p3.getX() <= result.getX()) && (p4.getX() >= result.getX())) || ((p1.getY() <= result.getY()) && (p2.getY() >= result.getY()) && (p3.getY() <= result.getY()) && (p4.getY() >= result.getY()))) )
            return result;
        else return null;
    }

    enum Event {
        TOPPOINT,
        LOWESTPOINT,
        INTERSECTION,
    }

    class EventPoint {
        private Event eventType;
        private HashSet<Segment> eventSegments = new HashSet<>();

        public EventPoint(Event eventType) {
            this.eventType = eventType;
        }

        public Event getEventType() {
            return eventType;
        }

        public Set<Segment> getEventSegments() {
            return eventSegments;
        }

        public void setEventSegments(HashSet<Segment> eventSegments) {
            this.eventSegments = eventSegments;
        }

        public void setEventType(Event eventType) {
            this.eventType = eventType;
        }

        public void addSegment(Segment segment) {
            eventSegments.add(segment);
        }

        @Override
        public String toString() {
            return "EventPoint{" +
                    "eventType=" + eventType +
                    ", eventSegments=" + eventSegments +
                    '}';
        }
    }

}
