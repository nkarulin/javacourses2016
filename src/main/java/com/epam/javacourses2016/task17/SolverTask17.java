package com.epam.javacourses2016.task17;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;

import java.util.*;

/**
 * На плоскости задано N отрезков.
 * Найти точку (возможно несколько) пересечения двух отрезков, имеющую минимальную абсциссу.
 * Использовать класс TreeMap.
 */
public class SolverTask17 {

    /**
     * Осуществляет анализ переданных отрезков.
     *
     * @param segments Множество отрезков.
     * @return Множество точек пересечения, имеющих минимальную абсциссу.
     */
    public Set<Point2D> analyze(Set<Segment> segments) {
        Set<Point2D> result = new HashSet<>();
        TreeMap<Point2D, EventPoint> eventPointTreeMap = new TreeMap<>(Collections.reverseOrder());//Статус всех событий на карте
        TreeMap<Point2D, Segment> segmentTreeMap = new TreeMap<>();//Статус пересекающей прямой
        /* for(Segment s : segments) {
           if(s.getA().compareTo(s.getB()) == 1) {
                if(eventPointTreeMap.containsKey(s.getA())) {
                    eventPointTreeMap.get(s.getA()).setEventType(Event.INTERSECTION);
                    eventPointTreeMap.get(s.getA()).addSegment(s);
                } else {
                    EventPoint eventPoint = new EventPoint(Event.TOPPOINT);
                    eventPoint.addSegment(s);
                    eventPointTreeMap.put(s.getA(),eventPoint);
                }
                if(eventPointTreeMap.containsKey(s.getB())) {
                    eventPointTreeMap.get(s.getB()).setEventType(Event.INTERSECTION);
                    eventPointTreeMap.get(s.getB()).addSegment(s);
                } else {
                    EventPoint eventPoint = new EventPoint(Event.LOWESTPOINT);
                    eventPoint.addSegment(s);
                    eventPointTreeMap.put(s.getB(),eventPoint);
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
        Iterator<Map.Entry<Point2D, EventPoint>> it = eventPointTreeMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Point2D, EventPoint> point2DSetEntry = it.next();
            System.out.println(point2DSetEntry.getKey() + " " + point2DSetEntry.getValue());
            Point2D point2D = handlePoint(point2DSetEntry, segmentTreeMap, eventPointTreeMap).getKey();
            if(point2D != null)
                result.add(point2D);
        }*/
        return result;
    }

    private Map.Entry<Point2D, EventPoint> handlePoint(Map.Entry<Point2D, EventPoint> eventPoint, TreeMap<Point2D, Segment> segmentTreeMap, TreeMap<Point2D, EventPoint> eventPointTreeMap) {
        Event event = eventPoint.getValue().getEventType();
        Map.Entry<Point2D, EventPoint> res = null;
        switch (event) {
            case TOPPOINT:
                Iterator<Segment> it = eventPoint.getValue().getEventSegments().iterator();
                Segment segment = it.next();
                segmentTreeMap.put(eventPoint.getKey(),segment);
                for(Map.Entry<Point2D, Segment> s : segmentTreeMap.entrySet()) {
                    Point2D newPoint = findIntersection(s.getValue().getA(),s.getValue().getB(),segment.getA(),segment.getB());
                    if(newPoint != null) {
                        EventPoint eventPoint1 = new EventPoint(Event.INTERSECTION);
                        eventPoint1.addSegment(segment);
                        eventPoint1.addSegment(s.getValue());
                        eventPointTreeMap.put(newPoint, eventPoint1);
                    }
                }
                break;
            case LOWESTPOINT:
                eventPointTreeMap.remove(eventPoint);
                break;
            case INTERSECTION:
                res = eventPoint;
            default:
                break;
        }
        return res;
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
