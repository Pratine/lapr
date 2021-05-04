/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.utils.DataBase;
import lapr.project.utils.UnitConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author salva
 */
public class ImportXML implements Importable {

    /* 
     * Network tags for xml
     */
    private static final String ID_TAG = "id";
    private static final String BEGIN_TAG = "begin";
    private static final String END_TAG = "end";
    private static final String NETWORK_TAG = "Network";
    private static final String JUNCTION_TAG = "node";
    private static final String ROAD_SSECTION_TAG = "road_section";
    private static final String ROAD_TAG = "road";
    private static final String CLASS_TAG = "class";
    private static final String ROAD_ID_TAG = "road_id";
    private static final String TYPOLOGY_TAG = "typology";
    private static final String DIRECTION_TAG = "direction";
    private static final String TOLL_TAG = "class";
    private static final String WIND_DIRECTION_TAG = "wind_direction";
    private static final String WIND_SPEED_TAG = "wind_speed";
    private static final String SEGMENT_TAG = "segment";
    private static final String INITIAL_HEIGHT_TAG = "init_height";
    private static final String FINAL_HEIGHT_TAG = "final_height";
    private static final String LENGTH_TAG = "length";
    private static final String MAX_VELOCITY_TAG = "max_velocity";
    private static final String MIN_VELOCITY_TAG = "min_velocity";

    /*
    * To know if segment is bidirectional
     */
    private static final String DIRECTION_OF_SEGMENT = "bidirectional";

    /*
     * Vehicle tags for xml 
     */
    private static final String VEHICLE_LIST_TAG = "vehicle_list";
    private static final String VEHICLE_TAG = "vehicle";
    private static final String NAME_TAG = "name";
    private static final String DESCRIPTION_TAG = "description";
    private static final String TYPE_TAG = "type";
    private static final String TOLL_CLASS_TAG = "toll_class";
    private static final String MOTORIZATION_TAG = "motorization";
    private static final String FUEL_TAG = "fuel";
    private static final String MASS_TAG = "mass";
    private static final String LOAD_TAG = "load";
    private static final String DRAG_TAG = "drag";
    private static final String FRONTAL_AREA_TAG = "frontal_area";
    private static final String ROLLING_RESISTANCE_COEFFICIENT_TAG = "rrc";
    private static final String WHELL_SIZE_TAG = "wheel_size";
    private static final String VELOCITY_LIMIT_TAG = "velocity_limit";
    private static final String SEGMENT_TYPE_TAG = "segment_type";
    private static final String LIMIT_TAG = "limit";
    private static final String MIN_RPM_TAG = "min_rpm";
    private static final String MAX_RPM_TAG = "max_rpm";
    private static final String FINAL_DRIVE_RATIO_TAG = "final_drive_ratio";
    private static final String ENERGY_REGEN_TAG = "energy_regeneration_ratio";
    private static final String GEAR_TAG = "gear";
    private static final String GEAR_RATIO_TAG = "ratio";
    private static final String THROTTLE_TAG = "throttle";
    private static final String TORQUE_LOW_TAG = "torque_low";
    private static final String TORQUE_HIGH_TAG = "torque_high";
    private static final String RPM_LOW_TAG = "rpm_low";
    private static final String RPM_HIGH_TAG = "rpm_high";
    private static final String SFC_TAG = "SFC";
    private static final String REGIME_TAG = "regime";

    DataBase db = new DataBase();

    private static Document readFile(String filePath) throws ParserConfigurationException, IOException, SAXException {
        File file = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.normalize();
        return document;
    }

    /**
     *
     * @param project
     * @param filePath
     * @return true RoadNetwork was read
     */
    @Override
    public boolean importRoadNetwork(Project project, String filePath) {
        try {
            Document doc = readFile(filePath);
            Node networkNode = doc.getElementsByTagName(NETWORK_TAG).item(0);
            if (networkNode.getNodeType() == Node.ELEMENT_NODE) {
                Element networkElement = (Element) networkNode;

                extractNodes(networkElement, project);

                extractRoads(networkElement, project);

                extractSections(networkElement, project);
                
            }
            return true;
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            return false;
        }
        
    }

    /**
     *
     * @param project
     * @param filePath
     * @return true if vehicles were read
     */
    @Override
    public boolean importVehicles(Project project, String filePath) {
        try {
            Document document = readFile(filePath);

            Node vehicleListNode = document.getElementsByTagName(VEHICLE_LIST_TAG).item(0);
            if (vehicleListNode.getNodeType() == Node.ELEMENT_NODE) {
                Element vehicleListElement = (Element) vehicleListNode;

                extractVehicles(vehicleListElement, project);
            }
            return true;
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            return false;
        }
    }

    /*
    ############################
    #####ROADNETWORK SECTION####
    ############################
     */
    /**
     *
     * @param networkElement
     * @param project
     */
    private void extractNodes(Element networkElement, Project project) {
        NodeList junctionNodeList = networkElement.getElementsByTagName(JUNCTION_TAG);

        for (int i = 0; i < junctionNodeList.getLength(); i++) {
            Node junctionNode = junctionNodeList.item(i);

            if (junctionNode.getNodeType() == Node.ELEMENT_NODE) {
                Element junctionElement = (Element) junctionNode;

                Junction junction = project.newJunction();
                junction.setId(junctionElement.getAttribute(ID_TAG));

                if (junction.validate()) {
                    project.addJunction(junction);

                    db.openConnection();
                    db.insertJunction(junction.getId());
                }
            }
        }
    }

    /**
     *
     * @param networkElement
     * @param project
     */
    private void extractSections(Element networkElement, Project project) {

        NodeList roadSectionNodeList = networkElement.getElementsByTagName(ROAD_SSECTION_TAG);

        for (int i = 0; i < roadSectionNodeList.getLength(); i++) {
            Node roadSectionNode = roadSectionNodeList.item(i);

            if (roadSectionNode.getNodeType() == Node.ELEMENT_NODE) {
                Element roadSectionElement = (Element) roadSectionNode;
                Section section = project.newSection();

                section.setBegginingJunction(roadSectionElement.getAttribute(BEGIN_TAG));
                section.setEndingJunction(roadSectionElement.getAttribute(END_TAG));
                section.setRoad(project.getRegistryRoads().getRoadByName(roadSectionElement.getElementsByTagName(ROAD_ID_TAG).item(0).getTextContent()));
                String direction = roadSectionElement.getElementsByTagName(DIRECTION_TAG).item(0).getTextContent();
                if (direction.equals(DIRECTION_OF_SEGMENT)) {
                    section.setDirection(true);
                } else {
                    section.setDirection(false);
                }
                extractToll_Fare(roadSectionElement, section);
                extractSegment(roadSectionElement, section.getSegmentsList());

                if (section.validate()) {
                    project.addSection(section);

//                    db.openConnection();
//                    db.insertSection(section.getDirection(), section.getRoad().getName(), section.getBegginingJunction().getId(), section.getEndingJunction().getId());
                }

                if (direction.equalsIgnoreCase(DIRECTION_OF_SEGMENT)) {
                    Section otherSection = project.newSection();

                    otherSection.setEndingJunction(roadSectionElement.getAttribute(BEGIN_TAG));
                    otherSection.setBegginingJunction(roadSectionElement.getAttribute(END_TAG));
                    otherSection.setRoad(project.getRegistryRoads().getRoadByName(roadSectionElement.getElementsByTagName(ROAD_ID_TAG).item(0).getTextContent()));
                    otherSection.setDirection(Boolean.TRUE);

                    if (!(roadSectionElement.getAttribute(TOLL_TAG).isEmpty())) {
                        section.setToll(Integer.parseInt(roadSectionElement.getAttribute(ID_TAG)), Double.parseDouble(roadSectionElement.getElementsByTagName(CLASS_TAG).item(0).getTextContent()));
                    }
                    extractToll_Fare(roadSectionElement, otherSection);
                    extractSegmentReverse(roadSectionElement, otherSection.getSegmentsList());

                    if (section.validate()) {
                        project.addSection(otherSection);
                    }
                }
            }
        }
    }

    /**
     *
     * @param networkElement
     * @param project
     */
    private void extractRoads(Element networkElement, Project project) {
        NodeList roadNodeList = networkElement.getElementsByTagName(ROAD_TAG);

        for (int i = 0; i < roadNodeList.getLength(); i++) {
            Node roadNode = roadNodeList.item(i);

            if (roadNode.getNodeType() == Node.ELEMENT_NODE) {
                Element roadElement = (Element) roadNode;

                Road road = new Road();
                road.setName(roadElement.getAttribute(ID_TAG));
                road.setTypology(Typology.getByName(roadElement.getElementsByTagName(TYPOLOGY_TAG).item(0).getTextContent()));

                extractToll_Fare(roadElement, road);

                if (road.validate()) {
                    project.getRegistryRoads().addRoad(road);

                    db.openConnection();
                    db.insertRoad(road.getName(), project.getName());
                }
            }
        }
    }

    /**
     *
     * @param RoadElement
     * @param road
     */
    private void extractToll_Fare(Element RoadElement, Road road) {
        NodeList tollNodeList = RoadElement.getElementsByTagName(CLASS_TAG);

        for (int j = 0; j < tollNodeList.getLength(); j++) {
            Node classNode = tollNodeList.item(j);
            if (classNode.getNodeType() == Node.ELEMENT_NODE) {
                Element classElement = (Element) classNode;
                road.setToll(Integer.parseInt(classElement.getAttribute(ID_TAG)),
                        Double.parseDouble(classElement.getTextContent()));

//                db.openConnection();
//                db.insertTollFare(road.getName(), road.getTollFare().get(1), road.getTollFare().get(2), road.getTollFare().get(3));
            }
        }
    }

    /**
     *
     * @param roadSectionElement
     * @param section
     */
    private void extractToll_Fare(Element roadSectionElement, Section section) {
        NodeList tollNodeList = roadSectionElement.getElementsByTagName(CLASS_TAG);

        for (int j = 0; j < tollNodeList.getLength(); j++) {
            Node classNode = tollNodeList.item(j);
            if (classNode.getNodeType() == Node.ELEMENT_NODE) {
                Element classElement = (Element) classNode;
                section.setToll(Integer.parseInt(classElement.getAttribute(ID_TAG)),
                        Double.parseDouble(classElement.getTextContent()));

//                db.openConnection();
//                db.insertGantryFare(section.getTollFare().get(1), section.getTollFare().get(2), section.getTollFare().get(3));
            }
        }
    }

    /**
     *
     * @param networkElement
     * @param segmentList
     */
    private void extractSegment(Element networkElement, LinkedList<Segment> segmentList) {
        NodeList segmentsNodeList = networkElement.getElementsByTagName(SEGMENT_TAG);
        for (int i = 0; i < segmentsNodeList.getLength(); i++) {
            Node segmentNode = segmentsNodeList.item(i);

            if (segmentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element segmentElement = (Element) segmentNode;

                Segment segment = new Segment();
                segment.setId(Integer.parseInt(segmentElement.getAttribute(ID_TAG)));
                segment.setInitialHeight(Double.parseDouble(segmentElement.getElementsByTagName(INITIAL_HEIGHT_TAG).item(0).getTextContent()));
                segment.setFinalHeight(Double.parseDouble(segmentElement.getElementsByTagName(FINAL_HEIGHT_TAG).item(0).getTextContent()));
                segment.setLength(UnitConverter.kilometersToMeters(segmentElement.getElementsByTagName(LENGTH_TAG).item(0).getTextContent()));
                segment.setMaxSpeed(UnitConverter.kilometerPerHourToMetersPerSecond(segmentElement.getElementsByTagName(MAX_VELOCITY_TAG).item(0).getTextContent()));
                segment.setMinSpeed(UnitConverter.kilometerPerHourToMetersPerSecond(segmentElement.getElementsByTagName(MIN_VELOCITY_TAG).item(0).getTextContent()));
                segment.setWindDirection(Double.parseDouble(segmentElement.getElementsByTagName(WIND_DIRECTION_TAG).item(0).getTextContent()));
                segment.setWindSpeed(Double.parseDouble(segmentElement.getElementsByTagName(WIND_SPEED_TAG).item(0).getTextContent().split(" ")[0]));

                if (segment.validate()) {
                    if (!segmentList.contains(segment)) {
                        segmentList.add(segment);

//                        db.openConnection();
//                        db.insertSegment(segment.getId(), segment.getInitialHeight(), segment.getFinalHeight(), segment.getLength(), segment.getMaxSpeed(), 
//                                segment.getMinSpeed(), segment.getWindDirection(), segment.getWindSpeed());
                    }
                }
            }
        }
    }

    /**
     *
     * @param networkElement
     * @param segmentList
     */
    private void extractSegmentReverse(Element networkElement, LinkedList<Segment> segmentList) {
        NodeList segmentsNodeList = networkElement.getElementsByTagName(SEGMENT_TAG);

        for (int i = segmentsNodeList.getLength() - 1; i >= 0; i--) {
            Node segmentNode = segmentsNodeList.item(i);

            if (segmentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element segmentElement = (Element) segmentNode;

                Segment segment = new Segment();
                segment.setId(Integer.parseInt(segmentElement.getAttribute(ID_TAG)));
                segment.setFinalHeight(Double.parseDouble(segmentElement.getElementsByTagName(INITIAL_HEIGHT_TAG).item(0).getTextContent()));
                segment.setInitialHeight(Double.parseDouble(segmentElement.getElementsByTagName(FINAL_HEIGHT_TAG).item(0).getTextContent()));
                segment.setLength(UnitConverter.kilometersToMeters(segmentElement.getElementsByTagName(LENGTH_TAG).item(0).getTextContent()));
                segment.setMaxSpeed(UnitConverter.kilometerPerHourToMetersPerSecond(segmentElement.getElementsByTagName(MAX_VELOCITY_TAG).item(0).getTextContent()));
                segment.setMinSpeed(UnitConverter.kilometerPerHourToMetersPerSecond(segmentElement.getElementsByTagName(MIN_VELOCITY_TAG).item(0).getTextContent()));
                segment.setWindDirection(Double.parseDouble(segmentElement.getElementsByTagName(WIND_DIRECTION_TAG).item(0).getTextContent()) * -1);
                segment.setWindSpeed(Double.parseDouble(segmentElement.getElementsByTagName(WIND_SPEED_TAG).item(0).getTextContent().split(" ")[0]));
                if (segment.validate()) {
                    if (!segmentList.contains(segment)) {
                        segmentList.add(segment);
                    }
                }
            }
        }
    }

    /*
    ############################
    #######VEHICLE SECTION######
    ############################
     */
    /**
     *
     * @param vehicleListElement
     * @param project
     */
    private void extractVehicles(Element vehicleListElement, Project project) {
        NodeList vehicleNodeList = vehicleListElement.getElementsByTagName(VEHICLE_TAG);
        RegistryVehicle vehicleList = project.getRegistVehicle();
        for (int i = 0; i < vehicleNodeList.getLength(); i++) {
            Node vehicleNode = vehicleNodeList.item(i);

            if (vehicleNode.getNodeType() == Node.ELEMENT_NODE) {
                Element vehicleElement = (Element) vehicleNode;

                Vehicle vehicle = vehicleList.newVehicle();
                String motorization = vehicleElement.getElementsByTagName(MOTORIZATION_TAG).item(0).getTextContent();

                switch (motorization) {
                    case "combustion":
                        extractVehicleCombustion(vehicleElement, vehicle);
                        break;
                    case "electric":
                        extractVehicleEletric(vehicleElement, vehicle);
                        break;
                    default:
                        throw new IllegalArgumentException("No such motorization found");
                }
                if (vehicle.validate()) {
                    vehicleList.getVehicleList().add(vehicle);

//                    db.openConnection();
//                    db.insertVehicle(vehicle.getName(), vehicle.getDescription(), vehicle.getMass(), vehicle.getLoad(), 
//                            vehicle.getFrontalArea(), vehicle.getFrontalArea(), vehicle.getDragCoefficient(), vehicle.getResistanceCoefficient(), 
//                            vehicle.getEnergyRatio(), vehicle.getWheelSize(), vehicle.getMin_rpm(), vehicle.getMax_rpm(), 
//                            vehicle.getFinalDriveRatio(), vehicle.getMotorization().toString(), project.getName(), vehicle.getTollClass(), vehicle.getType().toString(), vehicle.getFuel().toString());
                }
            }
        }

    }

    /**
     *
     * @param vehicleElement
     * @param vehicle
     */
    private void extractVehicleCombustion(Element vehicleElement, Vehicle vehicle) {
        extractVehicleC(vehicleElement, vehicle);
        extractGearCombustion(vehicleElement, vehicle);
        extractThrottlesCombustion(vehicleElement, vehicle);
    }

    /**
     *
     * @param vehicleElement
     * @param vehicle
     */
    private void extractVehicleEletric(Element vehicleElement, Vehicle vehicle) {
        extractVehicleE(vehicleElement, vehicle);
        extractGearEletric(vehicleElement, vehicle);
        extractThrottlesElectric(vehicleElement, vehicle);
    }

    /**
     *
     * @param vehicleElement
     * @param vehicle
     */
    private void extractVehicleC(Element vehicleElement, Vehicle vehicle) {
        vehicle.setName(vehicleElement.getAttribute(NAME_TAG));
        vehicle.setDescription(vehicleElement.getAttribute(DESCRIPTION_TAG));
        vehicle.setType(Type.valueOf(vehicleElement.getElementsByTagName(TYPE_TAG).item(0).getTextContent().toUpperCase()));
        vehicle.setTollClass(Integer.parseInt(vehicleElement.getElementsByTagName(TOLL_CLASS_TAG).item(0).getTextContent()));
        vehicle.setMotorization(Motorization.valueOf(vehicleElement.getElementsByTagName(MOTORIZATION_TAG).item(0).getTextContent().toUpperCase()));
        vehicle.setFuel(Fuel.valueOf(vehicleElement.getElementsByTagName(FUEL_TAG).item(0).getTextContent().toUpperCase()));
        vehicle.setMass(Double.parseDouble(vehicleElement.getElementsByTagName(MASS_TAG).item(0).getTextContent().split(" ")[0]));
        vehicle.setLoad(Double.parseDouble(vehicleElement.getElementsByTagName(LOAD_TAG).item(0).getTextContent().split(" ")[0]));
        vehicle.setDragCoefficient(Double.parseDouble(vehicleElement.getElementsByTagName(DRAG_TAG).item(0).getTextContent()));
        vehicle.setFrontalArea(Double.parseDouble(vehicleElement.getElementsByTagName(FRONTAL_AREA_TAG).item(0).getTextContent()));
        vehicle.setResistanceCoefficient(Double.parseDouble(vehicleElement.getElementsByTagName(ROLLING_RESISTANCE_COEFFICIENT_TAG).item(0).getTextContent()));
        vehicle.setWheelSize(Double.parseDouble(vehicleElement.getElementsByTagName(WHELL_SIZE_TAG).item(0).getTextContent()));
        vehicle.setMin_rpm(Integer.parseInt(vehicleElement.getElementsByTagName(MIN_RPM_TAG).item(0).getTextContent()));
        vehicle.setMax_rpm(Integer.parseInt(vehicleElement.getElementsByTagName(MAX_RPM_TAG).item(0).getTextContent()));
        vehicle.setFinalDriveRatio(Double.parseDouble(vehicleElement.getElementsByTagName(FINAL_DRIVE_RATIO_TAG).item(0).getTextContent()));

        extractVelocities(vehicleElement, vehicle);
    }

    /**
     *
     * @param vehicleElement
     * @param vehicle
     */
    private void extractVehicleE(Element vehicleElement, Vehicle vehicle) {
        vehicle.setName(vehicleElement.getAttribute(NAME_TAG));
        vehicle.setDescription(vehicleElement.getAttribute(DESCRIPTION_TAG));
        vehicle.setType(Type.valueOf(vehicleElement.getElementsByTagName(TYPE_TAG).item(0).getTextContent().toUpperCase()));
        vehicle.setTollClass(Integer.parseInt(vehicleElement.getElementsByTagName(TOLL_CLASS_TAG).item(0).getTextContent()));
        vehicle.setMotorization(Motorization.valueOf(vehicleElement.getElementsByTagName(MOTORIZATION_TAG).item(0).getTextContent().toUpperCase()));
        vehicle.setFuel(Fuel.valueOf(vehicleElement.getElementsByTagName(FUEL_TAG).item(0).getTextContent().toUpperCase()));
        vehicle.setMass(Double.parseDouble(vehicleElement.getElementsByTagName(MASS_TAG).item(0).getTextContent().split(" ")[0]));
        vehicle.setLoad(Double.parseDouble(vehicleElement.getElementsByTagName(LOAD_TAG).item(0).getTextContent().split(" ")[0]));
        vehicle.setDragCoefficient(Double.parseDouble(vehicleElement.getElementsByTagName(DRAG_TAG).item(0).getTextContent()));
        vehicle.setFrontalArea(Double.parseDouble(vehicleElement.getElementsByTagName(FRONTAL_AREA_TAG).item(0).getTextContent()));
        vehicle.setResistanceCoefficient(Double.parseDouble(vehicleElement.getElementsByTagName(ROLLING_RESISTANCE_COEFFICIENT_TAG).item(0).getTextContent()));
        vehicle.setWheelSize(Double.parseDouble(vehicleElement.getElementsByTagName(WHELL_SIZE_TAG).item(0).getTextContent()));
        vehicle.setMin_rpm(Integer.parseInt(vehicleElement.getElementsByTagName(MIN_RPM_TAG).item(0).getTextContent()));
        vehicle.setMax_rpm(Integer.parseInt(vehicleElement.getElementsByTagName(MAX_RPM_TAG).item(0).getTextContent()));
        vehicle.setFinalDriveRatio(Double.parseDouble(vehicleElement.getElementsByTagName(FINAL_DRIVE_RATIO_TAG).item(0).getTextContent()));
        vehicle.setEnergyRatio(Double.parseDouble(vehicleElement.getElementsByTagName(ENERGY_REGEN_TAG).item(0).getTextContent()));

        extractVelocities(vehicleElement, vehicle);
    }

    /**
     *
     * @param vehicleElement
     * @param vehicle
     */
    private void extractVelocities(Element vehicleElement, Vehicle vehicle) {
        NodeList velocityLimitNodeList = vehicleElement.getElementsByTagName(VELOCITY_LIMIT_TAG);

        for (int i = 0; i < velocityLimitNodeList.getLength(); i++) {
            Node velocityLimitNode = velocityLimitNodeList.item(i);

            if (velocityLimitNode.getNodeType() == Node.ELEMENT_NODE) {
                Element velocityLimitElement = (Element) velocityLimitNode;
                vehicle.insertVelocityLimit(velocityLimitElement.getElementsByTagName(SEGMENT_TYPE_TAG).item(0).getTextContent().toUpperCase(),
                        UnitConverter.kilometerPerHourToMetersPerSecondDouble(velocityLimitElement.getElementsByTagName(LIMIT_TAG).item(0).getTextContent()));
            }
        }
    }

    /**
     *
     * @param vehicleElement
     * @param vehicle
     */
    private void extractGearCombustion(Element vehicleElement, Vehicle vehicle) {
        NodeList gearNodeList = vehicleElement.getElementsByTagName(GEAR_TAG);
        for (int i = 0; i < gearNodeList.getLength(); i++) {
            Node gearNode = gearNodeList.item(i);
            if (gearNode.getNodeType() == Node.ELEMENT_NODE) {
                Element gearElement = (Element) gearNode;
                Gear gear = new Gear(Double.parseDouble(gearElement.getElementsByTagName(GEAR_RATIO_TAG).item(0).getTextContent()));
                vehicle.getGearList().add(gear);
            }
        }
    }

    /**
     *
     * @param vehicleElement
     * @param vehicle
     */
    private void extractGearEletric(Element vehicleElement, Vehicle vehicle) {
        NodeList gearNodeList = vehicleElement.getElementsByTagName(GEAR_TAG);
        for (int i = 0; i < gearNodeList.getLength(); i++) {
            Node gearNode = gearNodeList.item(i);
            if (gearNode.getNodeType() == Node.ELEMENT_NODE) {
                Element gearElement = (Element) gearNode;
                Gear gear = new Gear(Double.parseDouble(gearElement.getElementsByTagName(GEAR_RATIO_TAG).item(0).getTextContent()));
                vehicle.getGearList().add(gear);
            }
        }
    }

    /**
     *
     * @param vehicleElement
     * @param vehicle
     */
    private void extractThrottlesCombustion(Element vehicleElement, Vehicle vehicle) {
        NodeList throttleNodeList = vehicleElement.getElementsByTagName(THROTTLE_TAG);
        for (int i = 0; i < throttleNodeList.getLength(); i++) {
            Node throttleNode = throttleNodeList.item(i);
            if (throttleNode.getNodeType() == Node.ELEMENT_NODE) {
                Element throttleElement = (Element) throttleNode;
                Throttle throttle = new Throttle(Integer.parseInt(throttleElement.getAttribute(ID_TAG)));

                extractRegimeCombustion(throttleElement, throttle);

                vehicle.getRegistryThrottle().addThrottle(throttle);
            }
        }
    }

    /**
     *
     * @param throttleElement
     * @param throttle
     */
    private void extractRegimeCombustion(Element throttleElement, Throttle throttle) {
        NodeList regimeNodeList = throttleElement.getElementsByTagName(REGIME_TAG);
        for (int i = 0; i < regimeNodeList.getLength(); i++) {
            Node regimeNode = regimeNodeList.item(i);
            if (regimeNode.getNodeType() == Node.ELEMENT_NODE) {
                Element regimeElement = (Element) regimeNode;
                Regime regime = new Regime();
                regime.setTorqueLow(Integer.parseInt(regimeElement.getElementsByTagName(TORQUE_LOW_TAG).item(0).getTextContent()));
                regime.setTorqueHigh(Integer.parseInt(regimeElement.getElementsByTagName(TORQUE_HIGH_TAG).item(0).getTextContent()));
                regime.setRpmLow(Integer.parseInt(regimeElement.getElementsByTagName(RPM_LOW_TAG).item(0).getTextContent()));
                regime.setRpmHigh(Integer.parseInt(regimeElement.getElementsByTagName(RPM_HIGH_TAG).item(0).getTextContent()));
                regime.setSfc(Double.parseDouble(regimeElement.getElementsByTagName(SFC_TAG).item(0).getTextContent()));
                if (regime.validate()) {
                    throttle.getRegimeList().add(regime);
                }
            }
        }
    }

    /**
     *
     * @param vehicleElement
     * @param vehicle
     */
    private void extractThrottlesElectric(Element vehicleElement, Vehicle vehicle) {
        NodeList throttleNodeList = vehicleElement.getElementsByTagName(THROTTLE_TAG);
        for (int i = 0; i < throttleNodeList.getLength(); i++) {
            Node throttleNode = throttleNodeList.item(i);
            if (throttleNode.getNodeType() == Node.ELEMENT_NODE) {
                Element throttleElement = (Element) throttleNode;
                Throttle throttle = new Throttle(Integer.parseInt(throttleElement.getAttribute(ID_TAG)));

                extractRegimeElectric(throttleElement, throttle);

                vehicle.getRegistryThrottle().addThrottle(throttle);
            }
        }
    }

    /**
     *
     * @param throttleElement
     * @param throttle
     */
    private void extractRegimeElectric(Element throttleElement, Throttle throttle) {
        NodeList regimeNodeList = throttleElement.getElementsByTagName(REGIME_TAG);
        for (int i = 0; i < regimeNodeList.getLength(); i++) {
            Node regimeNode = regimeNodeList.item(i);
            if (regimeNode.getNodeType() == Node.ELEMENT_NODE) {
                Element regimeElement = (Element) regimeNode;
                Regime regime = new Regime();
                regime.setTorqueLow(Integer.parseInt(regimeElement.getElementsByTagName(TORQUE_LOW_TAG).item(0).getTextContent()));
                regime.setTorqueHigh(Integer.parseInt(regimeElement.getElementsByTagName(TORQUE_HIGH_TAG).item(0).getTextContent()));
                regime.setRpmLow(Integer.parseInt(regimeElement.getElementsByTagName(RPM_LOW_TAG).item(0).getTextContent()));
                regime.setRpmHigh(Integer.parseInt(regimeElement.getElementsByTagName(RPM_HIGH_TAG).item(0).getTextContent()));
                if (regime.validate()) {
                    throttle.getRegimeList().add(regime);
                }
            }
        }
    }

}
