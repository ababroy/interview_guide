package com.dsa.dp.creational;

public class BuilderDP
{
    public static void main ( String[] args )
    {
        Car car = new CarBuilder().setCarName( CarName.Ford ).setCarType( CarType.Compact_SUV ).setEngine( Engine.Normal ).setGearBoxType( GearBoxType.Manual )
            .setAc( AC.Automatic ).setHeadLight( HeadLight.Led ).setInfotainment( Infotainment.TouchScreen ).builder();
        System.out.println( car );
    }
}

enum CarName
{
    Ford, Honda, Hyundai, Suzuki, Skoda, Vokswagon, Renault, Nissan, Marcedes, Audi, BMW
}

enum CarType
{
    Compact_HatchBack, Hatchback, CrossOver, Compact_SUV, Mid_SUV, SUV, MUV, Compact_Sedan, Mid_Sedan, Sedan
}

enum GrillType
{
    Plastic, Chrome, ChromeWithBalckFinish
}

enum FuelType
{
    Petrol, Diesel, CNG
}

enum EngineType
{
    ThreeCylinder, FourCylinder, FiveCylinder
}

enum Engine
{
    Normal, Boost
}

enum SpeedGearBox
{
    Four, Five, Six, Seven, Eight, Nine, Ten
}

enum GearBoxType
{
    Manual, AutomaticWithManual, AutomaticWithoutManual, AutomaticWithPedalShift
}

enum GearMode
{
    Eco, Sport, Hill, Sand
}

enum Steering
{
    Plastic, Leatherite
}

enum SteeringAdjustment
{
    Tilted, TiltedWithTelescopic, NONE
}

enum Infotainment
{
    TouchScreen, NonTouchScreen
}

enum ClusterInstrument
{
    Digital, Analog, FullDigital
}

enum Wiper
{
    Front, Rear, AutoSensing
}

enum HeadLight
{
    Halogen, Led, HD, DRL
}

enum BackLight
{
    Halogen, Led, HD
}

enum FogLight
{
    Halogen, Led, HD
}

enum AC
{
    Automatic, Manual, RearBlower, RearBlowerWithAC
}

enum ACZone
{
    Dual, Single
}

enum WheelType
{
    Steel, Aloy, AloyWithDiamondCut, AloyWithChrome
}

enum WheelBase
{
    Thirteen, Fourteen, Fifteen, Sixteen, Seventeen, Eighteen, Nineteen, Twenty
}

class Car
{
    CarName carName;

    CarType carType;

    GrillType grillType;

    FuelType fuelType;

    Engine engine;

    EngineType engineType;

    SpeedGearBox speedGearBox;

    GearBoxType gearBoxType;

    GearMode gearMode;

    Steering steering;

    SteeringAdjustment steeringAdjustment;

    Infotainment infotainment;

    ClusterInstrument cuClusterInstrument;

    Wiper wiper;

    HeadLight headLight;

    BackLight backLight;

    FogLight fogLight;

    AC ac;

    ACZone acZone;

    WheelType wheelType;

    WheelBase wheelBase;

    public Car ( CarName carName, CarType carType, GrillType grillType, FuelType fuelType, Engine engine, EngineType engineType, SpeedGearBox speedGearBox, GearBoxType gearBoxType,
        GearMode gearMode, Steering steering, SteeringAdjustment steeringAdjustment, Infotainment infotainment, ClusterInstrument cuClusterInstrument, Wiper wiper,
        HeadLight headLight, BackLight backLight, FogLight fogLight, AC ac, ACZone acZone, WheelType wheelType, WheelBase wheelBase )
    {
        super();
        this.carName = carName;
        this.carType = carType;
        this.grillType = grillType;
        this.fuelType = fuelType;
        this.engine = engine;
        this.engineType = engineType;
        this.speedGearBox = speedGearBox;
        this.gearBoxType = gearBoxType;
        this.gearMode = gearMode;
        this.steering = steering;
        this.steeringAdjustment = steeringAdjustment;
        this.infotainment = infotainment;
        this.cuClusterInstrument = cuClusterInstrument;
        this.wiper = wiper;
        this.headLight = headLight;
        this.backLight = backLight;
        this.fogLight = fogLight;
        this.ac = ac;
        this.acZone = acZone;
        this.wheelType = wheelType;
        this.wheelBase = wheelBase;
    }

    @Override
    public String toString ()
    {
        return "carName=" + carName + "\ncarType=" + carType + "\ngrillType=" + grillType + "\nfuelType=" + fuelType + "\nengine=" + engine + "\nengineType=" + engineType
            + "\nspeedGearBox=" + speedGearBox + "\ngearBoxType=" + gearBoxType + "\ngearMode=" + gearMode + "\nsteering=" + steering + "\nsteeringAdjustment=" + steeringAdjustment
            + "\ninfotainment=" + infotainment + "\ncuClusterInstrument=" + cuClusterInstrument + "\nwiper=" + wiper + "\nheadLight=" + headLight + "\nbackLight=" + backLight
            + "\nfogLight=" + fogLight + "\nac=" + ac + "\nacZone=" + acZone + "\nwheelType=" + wheelType + "\nwheelBase=" + wheelBase;
    }

}

class CarBuilder
{
    CarName carName;

    CarType carType;

    GrillType grillType;

    FuelType fuelType;

    Engine engine;

    EngineType engineType;

    SpeedGearBox speedGearBox;

    GearBoxType gearBoxType;

    GearMode gearMode;

    Steering steering;

    SteeringAdjustment steeringAdjustment;

    Infotainment infotainment;

    ClusterInstrument clusterInstrument;

    Wiper wiper;

    HeadLight headLight;

    BackLight backLight;

    FogLight fogLight;

    AC ac;

    ACZone acZone;

    WheelType wheelType;

    WheelBase wheelBase;

    public CarBuilder setCarName ( CarName carName )
    {
        this.carName = carName;
        return this;
    }

    public CarBuilder setCarType ( CarType carType )
    {
        this.carType = carType;
        return this;
    }

    public CarBuilder setGrillType ( GrillType grillType )
    {
        this.grillType = grillType;
        return this;
    }

    public CarBuilder setFuelType ( FuelType fuelType )
    {
        this.fuelType = fuelType;
        return this;
    }

    public CarBuilder setEngine ( Engine engine )
    {
        this.engine = engine;
        return this;
    }

    public CarBuilder setEngineType ( EngineType engineType )
    {
        this.engineType = engineType;
        return this;
    }

    public CarBuilder setSpeedGearBox ( SpeedGearBox speedGearBox )
    {
        this.speedGearBox = speedGearBox;
        return this;
    }

    public CarBuilder setGearBoxType ( GearBoxType gearBoxType )
    {
        this.gearBoxType = gearBoxType;
        return this;
    }

    public CarBuilder setGearMode ( GearMode gearMode )
    {
        this.gearMode = gearMode;
        return this;
    }

    public CarBuilder setSteering ( Steering steering )
    {
        this.steering = steering;
        return this;
    }

    public CarBuilder setSteeringAdjustment ( SteeringAdjustment steeringAdjustment )
    {
        this.steeringAdjustment = steeringAdjustment;
        return this;
    }

    public CarBuilder setInfotainment ( Infotainment infotainment )
    {
        this.infotainment = infotainment;
        return this;
    }

    public CarBuilder setCuClusterInstrument ( ClusterInstrument cuClusterInstrument )
    {
        this.clusterInstrument = cuClusterInstrument;
        return this;
    }

    public CarBuilder setWiper ( Wiper wiper )
    {
        this.wiper = wiper;
        return this;
    }

    public CarBuilder setHeadLight ( HeadLight headLight )
    {
        this.headLight = headLight;
        return this;
    }

    public CarBuilder setBackLight ( BackLight backLight )
    {
        this.backLight = backLight;
        return this;
    }

    public CarBuilder setFogLight ( FogLight fogLight )
    {
        this.fogLight = fogLight;
        return this;
    }

    public CarBuilder setAc ( AC ac )
    {
        this.ac = ac;
        return this;
    }

    public CarBuilder setAcZone ( ACZone acZone )
    {
        this.acZone = acZone;
        return this;
    }

    public CarBuilder setWheelType ( WheelType wheelType )
    {
        this.wheelType = wheelType;
        return this;
    }

    public CarBuilder setWheelBase ( WheelBase wheelBase )
    {
        this.wheelBase = wheelBase;
        return this;
    }

    public Car builder ()
    {
        Car car = new Car( carName, carType, grillType, fuelType, engine, engineType, speedGearBox, gearBoxType, gearMode, steering, steeringAdjustment, infotainment,
            clusterInstrument, wiper, headLight, backLight, fogLight, ac, acZone, wheelType, wheelBase );
        return car;
    }
}
