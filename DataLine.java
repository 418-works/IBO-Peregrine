
public class DataLine {
    private String[] allData;
    // migration data variables
    private int originalOrder;
    private String whoEntered;
    private int masterPageNumber;
    private String location;
    private String bandSize;
    private String disposition;
    private String bandNumber;
    private String species;
    private int age;
    private String howAged;
    private String howAged2;
    private String sex;
    private String howSexed;
    private String howSexed2;
    private int skull;
    private int bp;
    private int cp;
    private int fat;
    private int muscle;
    private int bMlt;
    private String ffMlt;
    private int ffWear;
    private int wing;
    private int tail;
    private double weight;
    private int status;
    private String date;
    private int year;
    private int day;
    private int month;
    // different way to look at date
    private int julian;
    private int capTime;
    private String site;
    private int netNumber;
    private boolean parasites;
    private String disp;
    private String notes;
    private String proofingNotes;

    public DataLine(String currentLine) {
        allData = currentLine.split(",");
    }

    public void setOrder(int i) {
        if (i < allData.length && !allData[i].equals("")) {
            try {
                originalOrder = Integer.parseInt(allData[i]);
            }
            catch (NumberFormatException e) {
                originalOrder = -1;
            }
        }
        else {
            originalOrder = -1;
        }
    }

    public void setWhoEntered(int i) {
        if (i < allData.length) {
            whoEntered = allData[i];
        }
    }

    public void setMasterPageNumber(int i) {
        if (i < allData.length && !allData[i].equals("")) {
            try {
                masterPageNumber = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                masterPageNumber = -1;
            }
        }
        else {
            masterPageNumber = -1;
        }
    }

    public void setLocation(int i) {
        if (i < allData.length) {
            location = allData[i];
        }
    }

    public void setBandSize(int i) {
        if (i < allData.length) {
            bandSize = allData[i];
        }
    }

    public void setDisposition(int i) {
        if (i < allData.length) {
            disposition = allData[i];
        }
    }

    public void setBandNumber(int i) {
        if (i < allData.length && !allData[i].equals("")) {
            bandNumber = allData[i];
        }
    }

    public void setSpecies(int i) {
        if (i < allData.length) {
            species = allData[i];
        }
    }

    public void setAge(int i) {
        if (i < allData.length && !allData[i].equals("")) {
            try {
                age = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                age = -1;
            }
        } else {
            age = -1;
        }
    }

    public void setHowAged(int i) {
        if (i < allData.length) {
            howAged = allData[i];
        }
    }

    public void setHowAged2(int i) {
        if (i < allData.length) {
            howAged2 = allData[i];
        }
    }

    public void setSex(int i) {
        if (i < allData.length) {
            sex = allData[i];
        }
    }

    public void setHowSexed(int i) {
        if (i < allData.length) {
            howSexed = allData[i];
        }
    }

    public void setHowSexed2(int i) {
        if (i < allData.length) {
            howSexed2 = allData[i];
        }
    }

    public void setSkull(int i) {
        if (i < allData.length && !allData[i].equals("")) {
            try {
                skull = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                skull = -1;
            }
        } else {
            // if skull data field is blank set to -1
            skull = -1;
        }
    }

    public void setBP(int i) {
        if (i < allData.length && !allData[i].equals("")) {
            try {
                bp = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                bp = -1;
            }
        } else {
            bp = -1;
        }
    }

    public void setCP(int i) {
        if (i < allData.length && !allData[i].equals("")) {
            try {
                cp = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                cp = -1;
            }
        }
    }

    public void setFat(int i) {
        if (i < allData.length && !allData[i].equals("")) {
            try {
                fat = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                fat = -1;
            }
        } else {
            fat = -1;
        }
    }

    public void setMuscle(int i) {
        if (allData[i].equals("")) {
            muscle = -1;
        } else if (i < allData.length) {
            try {
                muscle = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                muscle = -1;
            }
        }
    }

    public void setBMlt(int i) {
        if (i < allData.length && !allData[i].equals("")) {
            try {
                bMlt = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                bMlt = -1;
            }
        } else {
            bMlt = -1;
        }
    }

    public void setFFMlt(int i) {
        if (i < allData.length) {
            ffMlt = allData[i];
        }
    }

    public void setFFWear(int i) {
        if (allData[i].equals("")) {
            ffWear = -1;
        } else {
            try {
                ffWear = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                ffWear = -1;
            }
        }
    }

    public void setWing(int i) {
        if (allData[i].equals("")) {
            wing = -1;
        } else {
            try {
                wing = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                wing = -1;
            }
        }
    }

    public void setTail(int i) {
        if (allData[i].equals("")) {
            tail = -1;
        } else {
            try {
                tail = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                tail = -1;
            }
        }
    }

    public void setWeight(int i) {
        if (allData[i].equals("")) {
            weight = -1.0;
        } else {
            try {
                weight = Double.parseDouble(allData[i]);
            } catch (NumberFormatException e) {
                weight = -1;
            }
        }
    }

    public void setStatus(int i) {
        if (allData[i].equals("")) {
            status = -1;
        } else {
            try {
                status = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                status = -1;
            }
        }
    }

    public void setDate(int i) {
        if (i < allData.length) {
            date = allData[i];
        }
    }

    public void setYear(int i) {
        if (allData[i].equals("")) {
            year = -1;
        } else {
            try {
                year = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                year = -1;
            }
        }
    }

    public void setMonth(int i) {
        if (allData[i].equals("")) {
            month = -1;
        } else {
            try {
                month = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                month = -1;
            }
        }
    }

    public void setDay(int i) {
        if (allData[i].equals("")) {
            day = -1;
        } else {
            try {
                day = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                day = -1;
            }
        }
    }

    public void setJulian(int i) {
        if (i < allData.length && !allData[i].equals("")) {
            try {
                julian = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                julian = -1;
            }
        } else {
            julian = -1;
        }
    }

    public void setCapTime(int i) {
        if (allData[i].equals("")) {
            capTime = -1;
        } else {
            try {
                capTime = Integer.parseInt(allData[i]);
            } catch (NumberFormatException e) {
                capTime = -1;
            }
        }
    }

    public void setSite(int i) {
        if (i < allData.length) {
            site = allData[i];
        }
    }

    public void setNetNum(int i) {
        if (i < allData.length) {
            if (allData[i].equals("")) {
                netNumber = -1;
            } 
            else {
                try {
                    netNumber = Integer.parseInt(allData[i]);
                } catch (NumberFormatException e) {
                    netNumber = -1;
                }
            }
        }
        else {
            netNumber = -1;
        }
    }

    public void setParasites(int i) {
        if (i < allData.length && !allData[i].equals("")) {
            if (allData[i].equals("Y")) {
                parasites = true;
            } else {
                parasites = false;
            }
        }
    }

    public void setDisp(int i) {
        if (i < allData.length) {
            disp = allData[i];
        } else {
            disp = "";
        }
    }

    public void setNotes(int i) {
        if (i < allData.length) {
            notes = allData[i];
        } else {
            notes = "";
        }
    }

    public void setProofingNotes(int i) {
        if (i < allData.length && !allData[i].equals("")) {
            proofingNotes = allData[i].replaceAll("\"", "\\\"");
            ;
        } else {
            proofingNotes = "";
        }
    }

    public void setCustomNotes(String note) {
        proofingNotes = note;
    }

    public int getDataSize() {
        return allData.length;
    }

    public int getOrder() {
        return originalOrder;
    }

    public String getWhoEntered() {
        return whoEntered;
    }

    public int getMasterPageNumber() {
        return masterPageNumber;
    }

    public String getLocation() {
        return location;
    }

    public String getBandSize() {
        return bandSize;
    }

    public String getDisposition() {
        return disposition;
    }

    public String getBandNumber() {
        return bandNumber;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getHowAged() {
        return howAged;
    }

    public String getHowAged2() {
        return howAged2;
    }

    public String getSex() {
        return sex;
    }

    public String getHowSexed() {
        return howSexed;
    }

    public String getHowSexed2() {
        return howSexed2;
    }

    public int getSkull() {
        return skull;
    }

    public int getBP() {
        return bp;
    }

    public int getCP() {
        return cp;
    }

    public int getFat() {
        return fat;
    }

    public int getMuscle() {
        return muscle;
    }

    public int getBMlt() {
        return bMlt;
    }

    public String getFFMlt() {
        return ffMlt;
    }

    public int getFFWear() {
        return ffWear;
    }

    public int getWing() {
        return wing;
    }

    public int getTail() {
        return tail;
    }

    public double getWeight() {
        return weight;
    }

    public int getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getJulian() {
        return julian;
    }

    public int getCapTime() {
        return capTime;
    }

    public String getSite() {
        return site;
    }

    public int getNetNum() {
        return netNumber;
    }

    public boolean hasParasites() {
        return parasites;
    }

    public String getDisp() {
        return disp;
    }

    public String getNotes() {
        return notes;
    }

    public String getProofingNotes() {
        return proofingNotes;
    }

}
