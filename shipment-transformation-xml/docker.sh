#!/bin/bash

set -euo pipefail


last_commit_hash=$(git rev-parse --short HEAD)
account_id=785199233751 # this is the account id of infoaxs_shared_infra_aws_account_id
region=${AWS_REGION:-"eu-west-1"}
ecr_repo_host=$account_id.dkr.ecr.$region.amazonaws.com
app_name="infoaxs-kafka-xml2json-transformer"
image_tag=$ecr_repo_host/$app_name:"$last_commit_hash"

function build() {
  echo "Building $image_tag..."
  docker build . -t "$image_tag"
  echo "Done."
}

function deploy() {
  echo "Authenticating to ECR..."
  aws ecr get-login-password --region "$region" | docker login --username AWS --password-stdin "$ecr_repo_host"
  echo "Pushing new image to $image_tag..."
  docker push "$image_tag"
  echo "Done."
}

"$@"