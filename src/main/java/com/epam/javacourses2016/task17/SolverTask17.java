package com.epam.javacourses2016.task17;

import com.epam.javacourses2016.Point2D;
import com.epam.javacourses2016.Segment;

import java.awt.*;
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
        TreeMap<Point2D, EventPoint> eventPointTreeMap = new TreeMap<>();//Статус всех событий на карте
        TreeMap<Point2D,Set<Segment>> point2DSetTreeMap = new TreeMap<>();//Статус пересекающей прямой
        for(Segment s : segments) {
            if(s.getA().getY() > s.getB().getY()) {
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
            } else if(s.getA().getY() < s.getB().getY()) {
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
            } else {
                if(s.getA().getX() > s.getB().getX()) {
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
        }
        for( Map.Entry<Point2D, EventPoint> point2DSetEntry : eventPointTreeMap.entrySet()) {
            System.out.println(point2DSetEntry);
        }
        return null;
    }

    private void handlePoint(EventPoint eventPoint) {

    }

    enum Event {
        TOPPOINT,
        LOWESTPOINT,
        INTERSECTION,
    }

    class EventPoint {
        private Event eventType;
        private Set<Segment> eventSegments = new HashSet<>();

        public EventPoint(Event eventType) {
            this.eventType = eventType;
        }

        public Event getEventType() {
            return eventType;
        }

        public Set<Segment> getEventSegments() {
            return eventSegments;
        }

        public void setEventSegments(Set<Segment> eventSegments) {
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
