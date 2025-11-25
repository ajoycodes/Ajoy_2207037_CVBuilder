package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class CurriculumVitae {

    private String fn, em, ph, ad, sm, ed, ex;
    private final List<String> sk = new ArrayList<>();

    public void setFn(String v){ fn=v; }
    public void setEm(String v){ em=v; }
    public void setPh(String v){ ph=v; }
    public void setAd(String v){ ad=v; }
    public void setSm(String v){ sm=v; }
    public void setEd(String v){ ed=v; }
    public void setEx(String v){ ex=v; }
    public void addSk(String v){ if(!v.isBlank()) sk.add(v.trim()); }

    public String getFn() { return fn; }
    public String getEm() { return em; }
    public String getPh() { return ph; }
    public String getAd() { return ad; }
    public String getSm() { return sm; }
    public String getEd() { return ed; }
    public String getEx() { return ex; }
    public List<String> getSkills() { return sk; }

    public String html() {

        StringBuilder s = new StringBuilder();

        s.append("""
        <html>
        <head>
        <style>
            html, body {
                margin:0;
                padding:0;
                background:#f3f4f7;
                font-family:'Inter','Segoe UI',sans-serif;
            }

            .cv {
                width:95%;
                max-width:850px;
                margin:40px auto;
                padding:48px;
                background:#fff;
                border-radius:8px;
                box-sizing:border-box;
                box-shadow:0 15px 35px rgba(0,0,0,0.1);
                border-bottom:6px solid #4a6cf7;
            }

            .header {
                text-align:center;
                margin-bottom:42px;
            }

            .name {
                font-size:38px;
                font-weight:700;
                margin:0;
                color:#111;
            }

            .info {
                font-size:14px;
                font-weight:500;
                color:#4a6cf7;
                margin-top:8px;
            }

            .body {
                display:flex;
                gap:40px;
            }

            .left { width:32%; }
            .right { width:68%; }

            .sec-title {
                font-size:17px;
                font-weight:600;
                color:#222;
                margin-top:32px;
                margin-bottom:12px;
                padding:8px 10px;
                background:#eef2ff;
                border-left:4px solid #4a6cf7;
                border-radius:4px;
            }

            p {
                margin:0 0 12px 0;
                font-size:14px;
                color:#333;
                line-height:1.6;
            }

            ul { margin:0; padding-left:20px; }
            li { margin-bottom:6px; font-size:14px; }

            .skill-box {
                background:#f8faff;
                border:1px solid #dce3ff;
                padding:14px 20px;
                border-radius:6px;
            }

            .footer {
                margin-top:40px;
                text-align:center;
                padding-top:20px;
                border-top:1px solid #ccc;
                font-size:13px;
                color:#666;
            }

            @media(max-width:750px) {
                .body { flex-direction:column; }
                .left, .right { width:100%; }
            }
        </style>
        </head>

        <body>
            <div class='cv'>
                <div class='header'>
        """);

        s.append("<h1 class='name'>").append(fn).append("</h1>");
        s.append("<div class='info'>").append(em).append("  |  ").append(ph).append("  |  ").append(ad).append("</div>");

        s.append("""
                </div>
                <div class='body'>
                    <div class='left'>
                        <div class='sec-title'>Profile</div>
                        <p>
        """);

        String smHtml = sm == null ? "" : sm.replace("\n", "<br>");
        s.append(smHtml).append("</p>");

        s.append("""
                        <div class='sec-title'>Skills</div>
                        <div class='skill-box'>
                        <ul>
        """);

        sk.forEach(x -> s.append("<li>").append(x).append("</li>"));

        s.append("""
                        </ul>
                        </div>
                    </div>

                    <div class='right'>
                        <div class='sec-title'>Education</div>
                        <p>
        """);

        String edHtml = ed == null ? "" : ed.replace("\n", "<br>");
        s.append(edHtml).append("</p>");

        s.append("""
                        <div class='sec-title'>Experience</div>
                        <p>
        """);

        String exHtml = ex == null ? "" : ex.replace("\n", "<br>");
        s.append(exHtml).append("</p>");

        s.append("""
                    </div>
                </div>

                <div class='footer'>
        """);

        s.append("© ").append(fn).append(" — CV generated by Ajoy Saha - 2207037");

        s.append("""
                </div>
            </div>
        </body>
        </html>
        """);

        return s.toString();
    }
}