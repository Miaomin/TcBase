package tcbase;

public class Relation {
	private int id;
	private String type, sentence, link, arg1type, arg1name, arg2type, arg2name;
	
	public Relation (int id, String type, String sentence, String link, String arg1type, String arg1name, String arg2type, String arg2name){
		this.id = id;
		this.type = type;
		this.sentence = sentence;
		this.link = link;
		this.arg1type = arg1type;
		this.arg1name = arg1name;
		this.arg2type = arg2type;
		this.arg2name = arg2name;
	}
	
	
	
	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getSentence() {
		return sentence;
	}

	public String getLink() {
		return link;
	}

	public String getArg1type() {
		return arg1type;
	}

	public String getArg1name() {
		return arg1name;
	}

	public String getArg2type() {
		return arg2type;
	}

	public String getArg2name() {
		return arg2name;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setArg1type(String arg1type) {
		this.arg1type = arg1type;
	}

	public void setArg1name(String arg1name) {
		this.arg1name = arg1name;
	}

	public void setArg2type(String arg2type) {
		this.arg2type = arg2type;
	}

	public void setArg2name(String arg2name) {
		this.arg2name = arg2name;
	}

	@Override
    public String toString() {
        return String.format(
                "Relation[id=%d, type='%s', sentence='%s', link='%s', arg1type='%s', arg1name='%s',arg2type='%s', arg2name='%s' ]",
                id, type, sentence, link, arg1type, arg1name, arg2type, arg2name);
    }

}
