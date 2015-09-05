package com.javarush.test.level28.lesson15.big01.vo;

/**
 * Created by Alex on 26.05.2015.
 */
public class Vacancy
{
    private String title, salary, city, companyName, siteName, url;

    public String getTitle()
    {
        return title;
    }

    public String getSalary()
    {
        return salary;
    }

    public String getCity()
    {
        return city;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public String getSiteName()
    {
        return siteName;
    }

    public String getUrl()
    {
        return url;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setSalary(String salary)
    {
        this.salary = salary;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Vacancy)) return false;

        Vacancy vacancy = (Vacancy) o;

        if (!city.equals(vacancy.city)) return false;
        if (!companyName.equals(vacancy.companyName)) return false;
        if (!salary.equals(vacancy.salary)) return false;
        if (!siteName.equals(vacancy.siteName)) return false;
        if (!title.equals(vacancy.title)) return false;
        if (!url.equals(vacancy.url)) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = title.hashCode();
        result = 31 * result + salary.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + companyName.hashCode();
        result = 31 * result + siteName.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }
}
