import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Proofer {
    //fix cap time
    private ArrayList<DataLine> data;
    private final String[] reqCategories = { "original order", "who entered", "master page #", "location", "bandsize",
            "disposition (band code)", "band #", "species", "age", "ha", "ha2", "sex", "hs", "hs2", "skull", "bp", "cp", "fat",
            "muscle", "b mlt", "ff mlt", "ff wear", "wing", "tail", "weight", "status", "date", "yyyy", "mm", "dd",
            "julian", "cap time", "site", "net #", "parasites?", "disp", "notes", "proofing notes" };
    private int originalOrderIndex;
    private int whoEnteredIndex;
    private int masterPageNumberIndex;
    private int locationIndex;
    private int bandSizeIndex;
    private int dispositionIndex;
    private int bandNumberIndex;
    private int speciesIndex;
    private int ageIndex;
    private int howAgedIndex;
    private int howAged2Index;
    private int sexIndex;
    private int howSexedIndex;
    private int howSexed2Index;
    private int skullIndex;
    private int bpIndex;
    private int cpIndex;
    private int fatIndex;
    private int muscleIndex;
    private int bMltIndex;
    private int ffMltIndex;
    private int ffWearIndex;
    private int wingIndex;
    private int tailIndex;
    private int weightIndex;
    private int statusIndex;
    private int dateIndex;
    private int yearIndex;
    private int monthIndex;
    private int dayIndex;
    // different way to look at date
    private int julianIndex;
    private int capTimeIndex;
    private int siteIndex;
    private int netNumberIndex;
    private int parasitesIndex;
    private int dispIndex;
    private int notesIndex;
    private int proofingNotesIndex;
    private int counter;

    public static void main(String[] args) {
        new Proofer(new File("boise-river-full.csv"));
    }

    /**
     * Constructor
     * 
     * @param path
     */
    public Proofer(File file) {
        try {
            Scanner csvScanner = new Scanner(file);
            String[] fileCategories = csvScanner.nextLine().split(",");
            data = new ArrayList<DataLine>();
            for (String cat : reqCategories) {
                CategoryIndexValidatorAssigner(fileCategories, cat);
            }
            while (csvScanner.hasNextLine()) {
                String currentLine = csvScanner.nextLine();
                DataLine currentDataLine = new DataLine(currentLine);
                if (currentDataLine.getDataSize() == 0) {
                    break;
                }
                // initialize all bird variables on the current line
                currentDataLine.setOrder(originalOrderIndex);
                currentDataLine.setWhoEntered(whoEnteredIndex);
                currentDataLine.setMasterPageNumber(masterPageNumberIndex);
                currentDataLine.setLocation(locationIndex);
                currentDataLine.setBandSize(bandSizeIndex);
                currentDataLine.setDisposition(dispositionIndex);
                currentDataLine.setBandNumber(bandNumberIndex);
                currentDataLine.setSpecies(speciesIndex);
                currentDataLine.setAge(ageIndex);
                currentDataLine.setHowAged(howAgedIndex);
                currentDataLine.setHowAged2(howAged2Index);
                currentDataLine.setSex(sexIndex);
                currentDataLine.setHowSexed(howSexedIndex);
                currentDataLine.setHowSexed2(howSexed2Index);
                currentDataLine.setSkull(skullIndex);
                currentDataLine.setBP(bpIndex);
                currentDataLine.setCP(cpIndex);
                currentDataLine.setFat(fatIndex);
                currentDataLine.setMuscle(muscleIndex);
                currentDataLine.setBMlt(bMltIndex);
                currentDataLine.setFFMlt(ffMltIndex);
                currentDataLine.setFFWear(ffWearIndex);
                currentDataLine.setWing(wingIndex);
                currentDataLine.setTail(tailIndex);
                currentDataLine.setWeight(weightIndex);
                currentDataLine.setStatus(statusIndex);
                currentDataLine.setDate(dateIndex);
                currentDataLine.setYear(yearIndex);
                currentDataLine.setMonth(monthIndex);
                currentDataLine.setDay(dayIndex);
                currentDataLine.setJulian(julianIndex);
                currentDataLine.setCapTime(capTimeIndex);
                currentDataLine.setSite(siteIndex);
                currentDataLine.setNetNum(netNumberIndex);
                currentDataLine.setParasites(parasitesIndex);
                currentDataLine.setDisp(dispIndex);
                currentDataLine.setNotes(notesIndex);
                currentDataLine.setProofingNotes(proofingNotesIndex);
                data.add(currentDataLine);
                proofAll(currentDataLine);
                if (currentDataLine.getProofingNotes().contains("*")) {
                    System.out.println(currentDataLine.getBandNumber()); 
                    System.out.println(currentDataLine.getProofingNotes());
                }

            }
            csvScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void CategoryIndexValidatorAssigner(String[] categories, String category) {

        // if (!Arrays.asList(categories).contains(category)) {
        // throw new IllegalArgumentException(category + " category not in data file");
        // }
        loop: for (int i = 0; i < categories.length; i++) {
            String currentCategory = categories[i].toLowerCase();
            if (currentCategory.equals(category)) {
                switch (category) {
                    case "original order":
                    originalOrderIndex = i;
                    break loop;
                    case "who entered":
                    whoEnteredIndex = i;
                    break loop;
                    case "master page#":
                    masterPageNumberIndex = i;
                    break loop;
                    case "location":
                    locationIndex = i;
                    break loop;
                    case "bandsize":
                    bandSizeIndex = i;
                    break loop;
                    case "disposition (band code)":
                    dispositionIndex = i;
                    break loop;
                    case "band #":
                    bandNumberIndex = i;
                    break loop;
                    case "species":
                    speciesIndex = i;
                    break loop;
                    case "age":
                    ageIndex = i;
                    break loop;
                    case "ha":
                    howAgedIndex = i;
                    break loop;
                    case "ha2":
                    howAged2Index = i;
                    break loop;
                    case "sex":
                    sexIndex = i;
                    break loop;
                    case "hs":
                    howSexedIndex = i;
                    break loop;
                    case "hs2":
                    howSexed2Index = i;
                    break loop;
                    case "skull":
                    skullIndex = i;
                    break loop;
                    case "bp":
                    bpIndex = i;
                    break loop;
                    case "cp":
                    cpIndex = i;
                    break loop;
                    case "fat":
                    fatIndex = i;
                    break loop;
                    case "muscle":
                    muscleIndex = i;
                    break loop;
                    case "b mlt":
                    bMltIndex = i;
                    break loop;
                    case "ff mlt":
                    ffMltIndex = i;
                    break loop;
                    case "ff wear":
                    ffWearIndex = i;
                    break loop;
                    case "wing":
                    wingIndex = i;
                    break loop;
                    case "tail":
                    tailIndex = i;
                    break loop;
                    case "weight":
                    weightIndex = i;
                    break loop;
                    case "status":
                    statusIndex = i;
                    break loop;
                    case "date":
                    dateIndex = i;
                    break loop;
                    case "yyyy":
                    yearIndex = i;
                    break loop;
                    case "mm":
                    monthIndex = i;
                    break loop;
                    case "dd":
                    dayIndex = i;
                    break loop;
                    case "julian":
                    julianIndex = i;
                    break loop;
                    case "cap time":
                    capTimeIndex = i;
                    break loop;
                    case "site":
                    siteIndex = i;
                    break loop;
                    case "net #":
                    netNumberIndex = i;
                    break loop;
                    case "parasites?":
                    parasitesIndex = i;
                    break loop;
                    case "disp":
                    dispIndex = i;
                    break loop;
                    case "notes":
                    notesIndex = i;
                    break loop;
                    case "proofing notes":
                    proofingNotesIndex = i;
                    break loop;
                }
            }
        }
    }

    public void proofAll(DataLine line) {
        proofMuscle(line);
        proofSpecies(line);
        proofAge(line);
        proofAgeFFMolt(line);
        proofHowAgedFFMolt(line);
        proofHowAgedFFWear(line);
        proofAgeFFWear(line);
        proofFFWear(line);
        proofWing(line);
        proofTail(line);
        proofWeight(line);
        proofBP(line);
        proofCP(line);
        proofFat(line);
        proofBMlt(line);
        proofSex(line);
        proofSkullAge(line);
        proofHowSexed(line);
        proofAgeBPCP(line);
        proofFFMolt(line);
        proofBandSize(line);
        proofDisposition(line);
        proofStatus(line);
        proofDisp(line);
        proofYear(line);
        proofMonth(line);
        proofDay(line);
        proofCapTime(line);
        proofNet(line);
        proofNotes(line);
        proofAgeHAHS(line);
        proofhaha2(line);
        proofhshs2(line);
    }

    public void proofSpecies(DataLine line) {
        final String[] validSpecies = { "amgo", "amke", "amre", "amro", "auwa", "bade", "balo", "bcch", "bewr", "bggn",
                "bhco", "bhgr", "brcr", "brsp", "btyw", "buor", "bush", "cafi", "cahu", "canw", "caqu", "cavi", "cbch",
                "cedw", "chsp", "coha", "coni", "copo", "deju", "dowo", "dufl", "evgr", "flow", "fosp", "gcki", "gcsp",
                "grca", "grfl", "gtto", "gwcs", "hafl", "hawo", "heth", "hewa", "hofi", "howr", "lazb", "lefl", "lego",
                "lisp", "mgwa", "moch", "mwcs", "mywa", "nawa", "nofl", "nopo", "ocwa", "orju", "osfl", "pawr", "pisi",
                "rbnu", "rcki", "recr", "rnsa", "rowr", "rsfl", "sath", "savs", "sosp", "spto", "ssha", "stja", "swth",
                "tewa", "toso", "towa", "udej", "uyrw", "vath", "vesp", "wavi", "wbnu", "wcsp", "webl", "wefl", "weta",
                "wewp", "wifl", "wiwa", "ybch", "yewa", "yrwa" };
        if (!binarySearch(validSpecies, line.getSpecies().toLowerCase(), 0, validSpecies.length - 1)) {
            line.setCustomNotes(line.getProofingNotes() + "\n***" + line.getSpecies() + " is rare or does not exist.");
        }
    }

    private boolean binarySearch(String[] data, String key, int lo, int hi) {
        int mid = (hi + lo) / 2;
        boolean found = false;
        if (data[mid].equals(key)) {
            found = true;
        } else if (lo == hi) {
            return found;
        } else if (key.compareTo(data[mid]) < 0) {
            return binarySearch(data, key, lo, mid);
        } else if (key.compareTo(data[mid]) > 0) {
            return binarySearch(data, key, mid + 1, hi);
        }
        return found;
    }

    public void proofAge(DataLine line) {
        int age = line.getAge();
        if (!(age == 0 || age == 1 || age == 2 || age == 4 || age == 5 || age == 6)) {
            line.setCustomNotes(line.getProofingNotes() + "\n***Invalid age. Age must be 0, 1, 2, 4, 5, or 6");
        }
    }

    public void proofSex(DataLine line) {
        String sex = line.getSex();
        if (!(sex.equals("M") || sex.equals("F") || sex.equals("U"))) {
            line.setCustomNotes(line.getProofingNotes() + "\n***Invalid sex. Sex must be M, F, or U");
        }
    }

    public void proofAgeBPCP(DataLine line) {
        int age = line.getAge();
        int bp = line.getBP();
        int cp = line.getCP();
        if (age == 0 || age == 2 || age == 4) {
            if (bp > 0 || cp > 0) {
                line.setCustomNotes(line.getProofingNotes() + "\n***BP and CP must both be 0 if age = 0, 2, or 4");
            }
        }
    }

    public void proofHowSexed(DataLine line) {
        String hs = line.getHowSexed();
        String sex = line.getSex();
        int bp = line.getBP();
        int cp = line.getCP();
        if (sex.equals("F")) {
            if (!(hs.equals("PL") || hs.equals("BP") || hs.equals("WL"))) {
                line.setCustomNotes(line.getProofingNotes()
                    + "\n***Invalid how sexed value. Acceptable hs values for females are PL, BP, and WL");
            } else if (hs.equals("BP") && (bp == 0 || bp == -1)) {
                line.setCustomNotes(line.getProofingNotes() + "\n***If sexed by BP, BP value cannot be blank or 0");
            }
        } else if (sex.equals("M")) {
            // ask about CP
            if (!(hs.equals("PL") || hs.equals("CP") || hs.equals("WL"))) {
                line.setCustomNotes(line.getProofingNotes()
                    + "\n***Invalid how sexed value. Acceptable hs values for males are PL, CL, and WL");
            } else if (hs.equals("CL")) {
                if (!(cp == 2 || cp == 3)) {
                    line.setCustomNotes(line.getProofingNotes() + "\n***If sexed by CL, CP value must be 2 or 3");
                }
            }
        } else if (sex.equals("U")) {
            if (!(hs.equals("") || hs.equals("IC"))) {
                line.setCustomNotes(line.getProofingNotes()
                    + "\n***Invalid how sexed value. Acceptable hs values for sex = U are blank and IC");
            }
        }

    }

    public void proofFFMolt(DataLine line) {
        String ffMlt = line.getFFMlt();
        if (!(ffMlt.equals("N") || ffMlt.equals("S") || ffMlt.equals("J") || ffMlt.equals("A") || ffMlt.equals(""))) {
            line.setCustomNotes(line.getProofingNotes()
                + "\n***Invalid FF molt value. Acceptable values are N, S, J, A, and blank");
        }
    }

    public void proofBP(DataLine line) {
        int bp = line.getBP();
        if (bp > 5) {
            line.setCustomNotes(line.getProofingNotes() + "\n***BP cannot exceed 5");
        }
    }

    public void proofCP(DataLine line) {
        int cp = line.getCP();
        if (cp > 3) {
            line.setCustomNotes(line.getProofingNotes() + "\n***CP cannot exceed 3");
        }
    }

    public void proofFat(DataLine line) {
        int fat = line.getFat();
        if (fat > 5) {
            line.setCustomNotes(line.getProofingNotes() + "\n***Fat cannot exceed 5");
        }
    }

    public void proofBMlt(DataLine line) {
        int bMlt = line.getBMlt();
        if (bMlt > 4) {
            line.setCustomNotes(line.getProofingNotes() + "\n***Body molt cannot exceed 4");
        }
    }

    public void proofFFWear(DataLine line) {
        int ffWear = line.getFFWear();
        if (ffWear > 5) {
            line.setCustomNotes(line.getProofingNotes() + "\n***FF wear cannot exceed 5");
        }
    }

    public void proofMuscle(DataLine line) {
        double muscle = line.getMuscle();
        if (!(muscle == -1 || muscle == 2.5 || muscle == 3 || muscle == 4 || muscle == 5)) {
            if (muscle == 1 || muscle == 2) {
                if (line.getProofingNotes().equals("")) {
                    line.setCustomNotes("\n***Muscle cannot be 1 or 2 without a note");
                }
            } else {
                line.setCustomNotes(line.getProofingNotes()
                    + "\n***Muscle value invalid. Value must be 2.5, 3, 4, or 5. 1 and 2 with notes is acceptable");
            }
        }
    }

    public void proofSkullAge(DataLine line) {
        int skull = line.getSkull();
        int age = line.getAge();
        String species = line.getSpecies().toLowerCase();
        String howAged = line.getHowAged().toLowerCase();
        final String[] excSpecies = { "heth", "swth", "deju", "orju", "udej", "hafl", "dufl" };
        if (skull == 0 && !(age == 2 || age == 4)) {
            line.setCustomNotes(
                line.getProofingNotes() + "\n***Age cannot be " + age + " when skull is 0. Age must be 2 or 4");
        } else if (skull == 1 && !(age == 2 || age == 4)) {
            line.setCustomNotes(
                line.getProofingNotes() + "\n***Age cannot be " + age + " when skull is 1. Age must be 2 or 4");
        } else if (age != 2 && (skull == 3 || skull == 4)) {
            line.setCustomNotes(
                line.getProofingNotes() + "\n***Age cannot be " + age + " when skull is 3 or 4. Age must be 2");
        } else if (skull == 5 && age != 2) {
            if (age == 1 || age == 5 || age == 6) {
                // is exception species?
                boolean contains = false;
                for (String sp : excSpecies) {
                    if (species.equals(sp)) {
                        contains = true;
                    }
                }
                if (!contains) {
                    line.setCustomNotes(line.getProofingNotes() + "\n***Age cannot be " + age
                        + " when skull is 5 and species is not an exception. Age must be 2");
                }
            } else {
                line.setCustomNotes(
                    line.getProofingNotes() + "\n***Age cannot be " + age + " when skull is 5. Age must be 2");
            }
        } else if (skull == 6 && !(age == 1 || age == 5 || age == 6)) {
            if (!((age == 2 || age == 0) && species.equals("rcki"))) {
                line.setCustomNotes(line.getProofingNotes() + "\n***Age cannot be " + age
                    + " when skull is 6. Age must be 1, 5, 6, or 2 with rcki species");
            }
        } else if (howAged.equals("sk") && (skull == 7 || skull == 8)) {
            line.setCustomNotes(line.getProofingNotes() + "\n***How Aged cannot be skull when skull = 7, 8");
        }
    }

    public void proofLocation(DataLine line) {
        String location = line.getLocation();
        if (location.equals("")) {
            line.setCustomNotes(line.getProofingNotes() + "\n***Location cannot be empty");
        }
    }

    public void proofBandSize(DataLine line) {
        String bandSize = line.getBandSize();
        String disposition = line.getDisposition();
        if (!(bandSize.equals("") || bandSize.equals("0A") || bandSize.equals("0") || bandSize.equals("1")
            || bandSize.equals("1B") || bandSize.equals("1A") || bandSize.equals("2") || bandSize.equals("3")
            || bandSize.equals("3A") || bandSize.equals("3B"))) {
            if (bandSize.equals("R")) {
                if (!disposition.equals("R")) {
                    line.setCustomNotes(line.getProofingNotes() + "\n***Band size cannot be R when band code is not R");
                }
            } else if (bandSize.equals("U")) {
                if (!disposition.equals("U")) {
                    line.setCustomNotes(line.getProofingNotes() + "\n***Band size cannot be U when band code is not U");
                }
            } else {
                line.setCustomNotes(line.getProofingNotes()
                    + "\n***Band size invalid. Acceptable values: 0A, 0, 1, 1B, 1A, 2, 3, 3A, 3B");
            }
        }
    }

    public void proofAgeFFMolt(DataLine line) {
        int age = line.getAge();
        String ffMlt = line.getFFMlt();
        String species = line.getSpecies().toLowerCase();
        if ((age == 1 || age == 5 || age == 6)
        && !(ffMlt.equals("N") || ffMlt.equals("S") || ffMlt.equals("A") || ffMlt.equals(""))) {
            line.setCustomNotes(line.getProofingNotes() + "\n***Valid FFMlt values for ages 1,5,6 are N,S,A");
        } else if (age == 2 && !(ffMlt.equals("N") || ffMlt.equals("A") || ffMlt.equals(""))) {
            if (!(species.equals("ybch") || species.equals("spto") || species.equals("sosp") || species.equals("hofi")
                || species.equals("nofl") || species.equals("rsfl") || species.equals("hawo"))) {
                line.setCustomNotes(line.getProofingNotes()
                    + "\n***Valid FFMlt values for age 2 are N,A if not an exception species");
            }
        } else if (age == 4 && !(ffMlt.equals("J") || ffMlt.equals(""))) {
            line.setCustomNotes(line.getProofingNotes() + "\n***If age = 4 then FFMlt must be J");
        }
    }

    public void proofHowAgedFFMolt(DataLine line) {
        String ha = line.getHowAged().toLowerCase();
        String ffMlt = line.getFFMlt();
        if (ha.equals("mr") && !(ffMlt.equals("S") || ffMlt.equals("J"))) {
            line.setCustomNotes(line.getProofingNotes() + "\n***If How Aged is MR then FFMolt cannot be blank");
        }
    }

    public void proofHowAgedFFWear(DataLine line) {
        String ha = line.getHowAged().toLowerCase();
        int ffWear = line.getFFWear();
        if (ha.equals("ff") && ffWear < 0) {
            line.setCustomNotes(line.getProofingNotes() + "\n***If How Aged is FF then FFWear cannot be blank");
        }
    }

    public void proofAgeFFWear(DataLine line) {
        int age = line.getAge();
        int ffWear = line.getFFWear();
        String species = line.getSpecies();
        if ((age == 5 || age == 6) && (ffWear == 0 || ffWear == 1)) {
            line.setCustomNotes(
                line.getProofingNotes() + "\n***FF wear of 0 or 1 is suspicious for a bird of age 5 or 6.");
        } else if (age == 4 && ffWear >= 2) {
            line.setCustomNotes(line.getProofingNotes() + "\n***FF wear >= 2 is suspicious for a bird of age 4");
        } else if (age == 2 && ffWear >= 4) {
            line.setCustomNotes(line.getProofingNotes() + "\n***FF wear >= 4 is suspicious for a bird of age 2");
        }
    }

    public void proofWing(DataLine line) {
        int wing = line.getWing();
        if (wing > -1) {
            if (wing < 30 || wing > 200) {
                line.setCustomNotes(line.getProofingNotes() + "\n***Wing below 30 or above 200 is suspicious");
            }
        }
    }

    public void proofTail(DataLine line) {
        int tail = line.getTail();
        if (tail > -1) {
            if (tail < 30 || tail > 200) {
                line.setCustomNotes(line.getProofingNotes() + "\n***Tail below 30 or above 200 is suspicious");
            }
        }
    }

    public void proofWeight(DataLine line) {
        String species = line.getSpecies().toLowerCase();
        double weight = line.getWeight();
        if (weight > -1) {
            if (weight < 5) {
                if (!(species.equals("rcki") || species.equals("bchu") || species.equals("ruhu")
                    || species.equals("cahu"))) {
                    line.setCustomNotes(line.getProofingNotes() + "\n***" + weight
                        + " weight is suspicious for a bird that is not rcki, bchu, ruhu, or cahu");
                }
            } else if (weight > 200) {
                if (!species.equals("coha")) {
                    line.setCustomNotes(line.getProofingNotes() + "\n***" + weight
                        + " weight is suspicious for a bird that isn't a raptor");
                }
            }
        }
    }

    public void proofDisposition(DataLine line) {
        String disp = line.getDisposition();
        String species = line.getSpecies().toLowerCase();
        if (disp.equals("")) {
            line.setCustomNotes(line.getProofingNotes() + "\n***Band code cannot be empty");
        } else if (disp.equals("8") || disp.equals("4")) {
            if (!(species.equals("bade") || species.equals("balo"))) {
                line.setCustomNotes(
                    line.getProofingNotes() + "\n***Band codes 4 and 8 are only valid if species is BADE or BALO");
            }
        } else if (!(disp.equals("1") || disp.equals("5") || disp.equals("R") || disp.equals("U"))) {
            line.setCustomNotes(line.getProofingNotes()
                + "\n***Invalid band code. Acceptable values: 1, 5, R, U or 4 and 8 if species = BADE, BALO");
        }
    }

    public void proofStatus(DataLine line) {
        int status = line.getStatus();
        String notes = line.getNotes();
        String disp = line.getDisp();
        if (!(status == 300 || status == 500 || status == 0)) {
            if (status == -1) {
                line.setCustomNotes(line.getProofingNotes() + "\n***Status field cannot be blank");
            } else {
                line.setCustomNotes(
                    line.getProofingNotes() + "\n***" + status + " is an invalid status, must be 300 or 500");
            }
        } else if (status == 500 && notes.equals("") && disp.equals("")) {
            line.setCustomNotes(line.getProofingNotes() + "\n***Notes and disp cannot be blank when status is 500");
        }
    }

    public void proofDisp(DataLine line) {
        String disp = line.getDisp();
        int status = line.getStatus();
        String notes = line.getNotes();
        if (disp.equals("M") || disp.equals("O") || disp.equals("I") || disp.equals("S") || disp.equals("E")
        || disp.equals("D") || disp.equals("T") || disp.equals("W") || disp.equals("B") || disp.equals("L")
        || disp.equals("P") || disp.equals("")) {
            if (!disp.equals("")) {
                if (status != 500 && !disp.equals("D")) {
                    line.setCustomNotes(line.getProofingNotes() + "\n***If disp field is not empty status must be 500");
                }
                if (notes.equals("")) {
                    line.setCustomNotes(
                        line.getProofingNotes() + "\n***If disp field is not empty notes must be filled");
                }
            }
        } else {
            line.setCustomNotes(line.getProofingNotes() + "\n***" + disp + " is an invalid disp value");
        }
    }

    // proof date later. use date class?

    public void proofYear(DataLine line) {
        int year = line.getYear();
        String species = line.getSpecies().toLowerCase();
        if (year == -1 && !(species.equals("bade") || species.equals("balo"))) {
            line.setCustomNotes(line.getProofingNotes() + "\n***Year cannot be blank if band wasn't lost or destroyed");
        } else if (year < 1997 && !(species.equals("bade") || species.equals("balo"))) {
            line.setCustomNotes(line.getProofingNotes() + "\n***Year cannot be before 1997");
        }
    }

    public void proofMonth(DataLine line) {
        int month = line.getMonth();
        String species = line.getSpecies().toLowerCase();
        if (month == -1 && !(species.equals("bade") || species.equals("balo"))) {
            line.setCustomNotes(
                line.getProofingNotes() + "\n***Month cannot be blank if band wasn't lost or destroyed");
        } else if ((month < 2 || month > 11) && !(species.equals("bade") || species.equals("balo"))) {
            line.setCustomNotes(line.getProofingNotes() + "\n***Month cannot be December or January");
        }
    }

    public void proofDay(DataLine line) {
        int day = line.getDay();
        String species = line.getSpecies().toLowerCase();
        if (day == -1 && !(species.equals("bade") || species.equals("balo"))) {
            line.setCustomNotes(line.getProofingNotes() + "\n***Day cannot be blank if band wasn't lost or destroyed");
        } else if ((day < 1 || day > 31) && !(species.equals("bade") || species.equals("balo"))) {
            line.setCustomNotes(line.getProofingNotes() + "\n***Day cannot be < 1 or > 31");
        }
    }

    public void proofCapTime(DataLine line) {
        int capTime = line.getCapTime(); 
        if (capTime < 650 || capTime > 1300) {
            line.setCustomNotes(line.getProofingNotes() + "\n***Cap time must be between 650 and 1300");
        }
    }

    public void proofNet(DataLine line) {
        int net = line.getNetNum();
        if (net != -1) {
            if (net < 1 || net > 10) {
                System.out.println(net);
                line.setCustomNotes(line.getProofingNotes() + "\n***Net # must be between 1 and 10");
            }
        }
    }

    public void proofNotes(DataLine line) {
        String notes = line.getNotes();
        if (notes.contains("FF") || notes.contains("flat flies") || notes.contains("mites") || notes.contains("lice")
        || notes.contains("louse") || notes.contains("mite") || notes.contains("fly")) {
            if (!line.hasParasites()) {
                line.setCustomNotes(line.getProofingNotes()
                    + "\n***If notes contain FF, flat flies, mites, lice, louse, mite, or fly, then parasites must be Y.");
            }
        }
    }

    public void proofAgeHAHS(DataLine line) {
        int age = line.getAge();
        String ha = line.getHowAged();
        String ha2 = line.getHowAged2();
        String hs = line.getHowSexed();
        String species = line.getSpecies().toLowerCase();
        if (age == 0) {
            if (!(ha.equals("") || ha.equals("IC"))) {
                line.setCustomNotes(line.getProofingNotes() + "\n***invalid how aged for age 0");

            }
            if (!(hs.equals("") || hs.equals("IC"))){
                if(!(species.equals("rcki") || species.equals("gcki"))) {
                    line.setCustomNotes(line.getProofingNotes()
                        + "\n***known sex for a bird of unknown age is unlikely. exceptions = rcki, gcki");
                }
            }
        } else if (age == 1 || age == 6) {
            // "NL" should always be in first box for age 6.
            // Other options for the HA column for age 6 and 1: PL, NL, EY, FF, MB, PC, MR,
            // SK, TS, blank in second field only
            if (!ha.equals("NL") && age == 6) {
                line.setCustomNotes(line.getProofingNotes() + "\n***how aged must be NL if age = 6");
            } else if (age == 1 && !(ha.equals("PL") || ha.equals("NL") || ha.equals("EY") || ha.equals("FF")
                || ha.equals("MB") || ha.equals("PC") || ha.equals("MR") || ha.equals("SK") || ha.equals("TS"))) {
                line.setCustomNotes(line.getProofingNotes()
                    + "\n***how aged must be PL, NL, EY, FF, MB, PC, MR, SK, or TS if age = 1");
            }
            //PL,BP,CL,WL, blank
            if(!(hs.equals("PL") || hs.equals("BP") || hs.equals("CL") || hs.equals("WL") || hs.equals(""))) {
                line.setCustomNotes(line.getProofingNotes() + "\n***how sexed must be PL, BP, CL, WL, or blank if age = 1 or 6");
            }
        }
        else if(age == 5) {
            //"LP" MUST be in the first "how aged" field for all age 5's.
            //2nd "how aged" field may include: PL, EY, FF, MB, PC, MR, SK, TS, or blank
            if (!ha.equals("LP")) {
                line.setCustomNotes(line.getProofingNotes() + "\n***how aged must be LP in the first column if age = 5");
            }
            if (!(ha2.equals("PL") || ha2.equals("EY") || ha2.equals("FF") || ha2.equals("MB") || ha2.equals("PC") || ha2.equals("MR") || ha2.equals("SK") || ha.equals("TS") || ha.equals("")) ) {
                line.setCustomNotes(line.getProofingNotes() + "\n***how aged must be PL, EY, FF, MB, PC, MR, SK, TS, or blank if age = 5");
            }
            //PL,BP,CL,WL, blank
            if(!(hs.equals("PL") || hs.equals("BP") || hs.equals("CL") || hs.equals("WL") || hs.equals(""))) {
                line.setCustomNotes(line.getProofingNotes() + "\n***how sexed must be PL, BP, CL, WL, or blank if age = 5");
            }
        }
        else if(age == 2) {
            //PL,EY,FF,MB,PC,LP,MR,SK,TS, (blank allowed in second field only)
            if (!(ha.equals("PL") || ha.equals("EY") || ha.equals("FF") || ha.equals("MB") || ha.equals("PC") || ha.equals("LP") || ha.equals("MR") || ha.equals("SK") || ha.equals("TS"))) {
                line.setCustomNotes(line.getProofingNotes() + "\n***how aged must be PL, EY, FF, MB, PC, LP, MR, SK, or TS if age = 2");    
            }
            //if sex = U, hs can be blank
            if (!(hs.equals("PL") || hs.equals("WL") || hs.equals(""))) {
                line.setCustomNotes(line.getProofingNotes() + "\n***how sexed must be PL or WL if age = 2");
            }
        }
        else if(age == 4) {
            //The first "how aged" field MUST be "MR" and FF molt MUST be "J". 2nd "how aged" field may be: PL,EY,FF,MB,PC,LP,SK,TS, blank
            if (!(ha.equals("MR") && line.getFFMlt().equals("J"))) {
                line.setCustomNotes(line.getProofingNotes() + "\n***how aged must be MR and ff molt must be J if age = 4");
            }
            if (!(ha2.equals("PL") || ha2.equals("EY") || ha2.equals("FF") || ha2.equals("MB") || ha2.equals("PC") || ha2.equals("LP") || ha2.equals("SK") || ha2.equals("PC") || ha2.equals("TS") || ha2.equals(""))) {
                line.setCustomNotes(line.getProofingNotes () + "\n***how aged 2 must be PL, EY, FF, MB, PC, LP, SK, TS, or blank if age = 2");
            }
        }

    }

    public void proofhaha2(DataLine line) {
        String ha = line.getHowAged();
        String ha2 = line.getHowAged2();
        if(!(ha.equals("") || ha2.equals(""))) {
            if(ha.equals(ha2)) {
                line.setCustomNotes(line.getProofingNotes() + "\n***if both how aged columns are filled, both cannot be the same");
            }
        }
    }
    
    public void proofhshs2(DataLine line) {
        String hs = line.getHowSexed();
        String hs2 = line.getHowSexed2();
        if(!(hs.equals("") || hs2.equals(""))) {
            if(hs.equals(hs2)) {
                line.setCustomNotes(line.getProofingNotes() + "\n***if both how sexed columns are filled, both cannot be the same");
            }
        }
    }
}