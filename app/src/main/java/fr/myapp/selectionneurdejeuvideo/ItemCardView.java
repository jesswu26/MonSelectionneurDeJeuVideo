package fr.myapp.selectionneurdejeuvideo;

public class ItemCardView {

    private String textTitleList,textNoteList,imgList;

    public ItemCardView(String textTitleList, String textNoteList, String imgList, String textDescription) {
        this.textTitleList = textTitleList;
        this.textNoteList = textNoteList;
        this.imgList = imgList;
      //  this.textDescription = textDescription;
    }

//    public String getTextDescription() {
//        return textDescription;
//    }
//
//    public void setTextDescription(String textDescription) {
//        this.textDescription = textDescription;
//    }

    public ItemCardView(String img, String title, String note) {
        imgList=img;
        textTitleList = title;
        textNoteList = note;
    }

    public String getImgList() {
        return imgList;
    }

    public void setImgList(String imgList) {
        this.imgList = imgList;
    }

    public String getTextTitleList() {
        return textTitleList;
    }

    public void setTextTitleList(String textTitleList) {
        this.textTitleList = textTitleList;
    }

    public String getTextNoteList() {
        return textNoteList;
    }

    public void setTextNoteList(String textNoteList) {
        this.textNoteList = textNoteList;
    }
}
