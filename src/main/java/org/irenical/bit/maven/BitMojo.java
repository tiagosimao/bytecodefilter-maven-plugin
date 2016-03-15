package org.irenical.bit.maven;

import java.io.File;
import java.util.function.Consumer;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;

@Mojo(name="instrument", requiresDependencyResolution=ResolutionScope.COMPILE, defaultPhase=LifecyclePhase.PROCESS_CLASSES)
public class BitMojo extends AbstractMojo {

  @Parameter(required=true)
  private String consumerClass;
  
  @Parameter(defaultValue = "${project}")
  private MavenProject project;

  @Override
  public void execute() throws MojoExecutionException {
    try {
      System.out.println("INPUT: " + consumerClass);
      Class<?> got = Class.forName(consumerClass);
      @SuppressWarnings("unchecked")
      Consumer<File> consumer = (Consumer<File>) got.newInstance();
      consumer.accept(new File(project.getBuild().getOutputDirectory()));
    } catch(Exception e){
      throw new MojoExecutionException("Error handling class file", e);
    }
  }

}
