package json2java;

import java.util.ArrayList;

/**
 * A class representing a ticket object for data binding purposes
 *
 * @author      Nikos Stasinopoulos <nstasinopoulos@gmail.com>
 * @version     2010.0720
 * @since       1.6
 */
public class Ticket {

    /**
     * Subclass Versions realizing multiple versions ticket instances
     *
     * @author      Nikos Stasinopoulos <nstasinopoulos@gmail.com>
     * @version     2010.0720
     * @since       1.6
     */
    public static class Versions extends Ticket {

        public diffableAttributes diffable_attributes;
    }

    /**
     * Dummy - Subclass diffableAttributes for the diffable attributes array of each version
     *
     * @author      Nikos Stasinopoulos <nstasinopoulos@gmail.com>
     * @version     2010.0720
     * @since       1.6
     */
    public static class diffableAttributes extends Ticket {
    }
    public Ticket ticket;
    public int versionId;

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    /**
     * Subclass attachments controlling array of attachments to a ticket
     *
     * @author      Nikos Stasinopoulos <nstasinopoulos@gmail.com>
     * @version     2010.0720
     * @since       1.6
     */
    public static class attachments {

        public attachment image;
        public attachment attachment;

        /**
         * Dummy - Subclass attachments controlling each attachment to a ticket
         * 
         * @author      Nikos Stasinopoulos <nstasinopoulos@gmail.com>
         * @version     2010.0720
         * @since       1.6
         */
        public static class attachment {

            public String code;
            public String content_type;
            public String created_at;
            public String filename;
            public int height;
            public int id;
            public int uploader_id;
            public String url;
            public int width;
            public int size;

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getContent_type() {
                return content_type;
            }

            public void setContent_type(String content_type) {
                this.content_type = content_type;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getFilename() {
                return filename;
            }

            public void setFilename(String filename) {
                this.filename = filename;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUploader_id() {
                return uploader_id;
            }

            public void setUploader_id(int uploader_id) {
                this.uploader_id = uploader_id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }
        };
    };
    public ArrayList<attachments> attachments; //JSON Array bound to Arraylist<> in Java, see http://wiki.fasterxml.com/JacksonInFiveMinutes#Simple_Data_Binding_Example for type conversion
    public int assigned_user_id;
    public String assigned_user_name;
    public String body;
    public String body_html;
    public boolean closed;
    public String created_at;
    public int creator_id;
    public String creator_name;
    public String latest_body;
    public String milestone_due_on;
    public String milestone_title;
    public int milestone_id;
    public int number;
    public String original_body;
    public String original_body_html;
    public String permalink;
    public int priority;
    public int project_id;
    public String raw_data;
    public String state;
    public String tag;
    public String title;
    public String updated_at;
    public int user_id;
    public String user_name;
    public String url;
    public int attachments_count;
    public ArrayList<Versions> versions; //JSON Array bound to Arraylist<> in Java, see http://wiki.fasterxml.com/JacksonInFiveMinutes#Simple_Data_Binding_Example for type conversion

    //Setters - getters required by Jackson API Mapping Paradigm
    public int getAssigned_user_id() {
        return assigned_user_id;
    }

    public void setAssigned_user_id(int assigned_user_id) {
        this.assigned_user_id = assigned_user_id;
    }

    public String getAssigned_user_name() {
        return assigned_user_name;
    }

    public void setAssigned_user_name(String assigned_user_name) {
        this.assigned_user_name = assigned_user_name;
    }

//    public String getAttachments() {
//        return attachments;
//    }
//
//    public void setAttachments(String attachments) {
//        this.attachments = attachments;
//    }
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody_html() {
        return body_html;
    }

    public void setBody_html(String body_html) {
        this.body_html = body_html;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCreator_name() {
        return creator_name;
    }

    public void setCreator_name(String creator_name) {
        this.creator_name = creator_name;
    }

    public int getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    public String getLatest_body() {
        return latest_body;
    }

    public void setLatest_body(String latest_body) {
        this.latest_body = latest_body;
    }

    public String getMilestone_due_on() {
        if (milestone_due_on == null) {
            return "?";
        } //null values with ?
        else {
            return milestone_due_on;
        }
    }

    public void setMilestone_due_on(String milestone_due_on) {
        this.milestone_due_on = milestone_due_on;
    }

    public int getMilestone_id() {
        return milestone_id;
    }

    public void setMilestone_id(int milestone_id) {
        this.milestone_id = milestone_id;
    }

    public String getMilestone_title() {
        if (milestone_title == null) {
            return "?";
        } //null values with ?
        else {
            return milestone_title;
        }
    }

    public void setMilestone_title(String milestone_title) {
        this.milestone_title = milestone_title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOriginal_body() {
        return original_body;
    }

    public void setOriginal_body(String original_body) {
        this.original_body = original_body;
    }

    public String getOriginal_body_html() {
        return original_body_html;
    }

    public void setOriginal_body_html(String original_body_html) {
        this.original_body_html = original_body_html;
    }

    public String getPermalink() {
        if (permalink == null) {
            return "?";
        } //null values with ?
        else {
            return permalink;
        }
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getRaw_data() {
        if (raw_data == null) {
            return "?";
        } //null values with ?
        else {
            return raw_data;
        }
    }

    public void setRaw_data(String raw_data) {
        this.raw_data = raw_data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getAttachments_count() {
        return attachments_count;
    }

    public void setAttachments_count(int attachments_count) {
        this.attachments_count = attachments_count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ArrayList<Versions> getVersions() {
        return versions;
    }

    public void setVersions(ArrayList<Versions> versions) {
        this.versions = versions;
    }
}
