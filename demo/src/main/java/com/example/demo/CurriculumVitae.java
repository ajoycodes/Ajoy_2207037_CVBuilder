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

    public String html() {
        StringBuilder s=new StringBuilder();
        s.append("""
        <html>
        <head>
        <style>
           html, body {
               margin:0;
               padding:0;
               background:#f3f4f7;
               font-family:'Inter','Segoe UI',sans-serif;
               height:100%;
           }

           .cv {
               width:95%;
               max-width:850px;
               margin:40px auto;
               padding:48px;
               background:#ffffff;
               border-radius:8px;
               box-sizing:border-box;
           }

           .header {
               text-align:center;
               margin-bottom:42px;
           }

           .name {
               font-size:36px;
               font-weight:700;
               color:#111;
               margin:0;
           }

           .info {
               font-size:14px;
               color:#666;
               margin-top:6px;
           }

           .body {
               display:flex;
               gap:40px;
           }

           .left {
               width:32%;
           }

           .right {
               width:68%;
           }

           .sec-title {
               font-size:18px;
               font-weight:600;
               color:#222;
               padding-bottom:6px;
               border-bottom:1px solid #ddd;
               margin-top:32px;
               margin-bottom:14px;
           }

           p {
               margin:0 0 12px 0;
               font-size:14px;
               color:#333;
               line-height:1.55;
           }

           ul {
               margin:0;
               padding-left:20px;
           }

           li {
               margin-bottom:6px;
               font-size:14px;
           }

           .skill-box {
               background:#f7f8fa;
               border:1px solid #e5e5e5;
               padding:14px 20px;
               border-radius:6px;
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
        s.append("<div class='info'>").append(em).append(" • ").append(ph).append(" • ").append(ad).append("</div>");

        s.append("""
              </div>

              <div class='body'>
                 <div class='left'>
                    <div class='sec-title'>Profile</div>
                    <p>
        """).append(sm).append("</p>");

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
        """).append(ed).append("</p>");

        s.append("""
                    <div class='sec-title'>Experience</div>
                    <p>
        """).append(ex).append("</p>");

        s.append("""
                 </div>
              </div>

           </div>
        </body>
        </html>
        """);

        return s.toString();
    }
}